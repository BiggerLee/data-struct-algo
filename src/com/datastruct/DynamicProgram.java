package com.datastruct;

public class DynamicProgram {
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
