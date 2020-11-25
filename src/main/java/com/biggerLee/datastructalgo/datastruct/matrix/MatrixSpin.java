package com.datastruct.matrix;

/**
 * @description: 矩阵旋转
 * 给定字符串密文N*N矩阵，解密矩阵也为N*N,由0和1组成，解密时，将密文和解密矩阵重合，从上往下，从左往右依次读出为0的字符值，
 * 然后顺时针旋转90度解密矩阵再次读密文矩阵，共读4次。
 */
public class MatrixSpin {
    public static void main(String[] args) {
        int n = 4;
        int[][] des = new int[n][n];
        char[][] content = new char[n][n];
        StringBuilder sb = new StringBuilder();
        int k = 0;
        while (k<4) {
            for(int i = 0;i < n; i++) {
                for(int j=0;j<n;j++) {
                    if(des[j][i] == 0) {
                        sb.append(content[j][i]);
                    }
                }
            }
            rotate(des);
            k++;
        }
        System.out.println(sb.toString());
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] m = new int[n][n];
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                m[row][col] = matrix[n-1-col][row];
            }
        }
        //再赋值回matrix，注意java是形参是引用传递
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                matrix[row][col] = m[row][col];
            }
        }
    }

}
