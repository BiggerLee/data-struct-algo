package com.zookeeper;


import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ZookeeperTest {
    public static void main(String[] args) throws IOException, BiffException {
        String path = "/java";
        ZkClient zkClient = new ZkClient("xxx");
        if(!zkClient.exists("/java")) {
            zkClient.create(path, null, CreateMode.PERSISTENT);
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Runnable runnable = () -> {
            zkClient.subscribeChildChanges(path,new IZkChildListener() {
                @Override
                public void handleChildChange(String parentPath, List<String> currentChilds) throws Exception {
                    try {
                        StringBuilder sb = new StringBuilder();
                        if (CollectionUtils.isNotEmpty(currentChilds)) {
                            currentChilds.forEach(str->sb.append(str));
                        }
                        System.out.println("zkData changed" + sb.toString());
                    }finally {
                        countDownLatch.countDown();
                    }
                }
            });
        };
        Thread thread = new Thread(runnable);
        thread.start();
        try {
            countDownLatch.await(300000, TimeUnit.MILLISECONDS);
        } catch (Exception e){
            System.out.println("fail");
        }
        System.out.println("success");
    }
}
