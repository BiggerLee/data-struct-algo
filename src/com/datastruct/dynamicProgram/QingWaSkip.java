package com.datastruct.dynamicProgram;

/**
 *  问题描述：一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法
 */
public class QingWaSkip {
    public static void main(String[] args) {
        System.out.println(qingWaSkip(5));
    }

    private static int qingWaSkip(int n) {
        int i = 2;
        int[] qw = new int[n];
        qw[2] = 3;
        qw[1] = 2;
        qw[0] = 1;
        while( i < n ) {
            qw[i] = qw[i-1] + qw[i-2];
            i++;
        }
        return qw[n-1];
    }
}
