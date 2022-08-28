package com.sunbeam;

public class spiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,5,7,9,10,11},
                {6,10,12,13,20,21},
                {9,25,29,30,32,41},
                {15,55,59,63,68,70},
                {40,70,79,81,95,105}
        };
        for(int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[i].length; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        int totalElements = matrix.length * matrix[0].length;
        int counter = 0;
        int minr = 0;
        int minc = 0;
        int maxr = matrix.length -1;
        int maxc = matrix[0].length-1;

        while(counter < totalElements){
            for (int i=minc, j=minr; i<= maxc && counter < totalElements; i++){
                System.out.print(matrix[j][i]+" ");
                counter++;
            }
            minr++;
            for (int i=minr, j=maxc; i<= maxr && counter < totalElements; i++){
                System.out.print(matrix[i][j]+" ");
                counter++;
            }
            maxc--;
            for (int i=maxc, j=maxr; i>= minc && counter < totalElements; i--){
                System.out.print(matrix[j][i]+" ");
                counter++;
            }
            maxr--;
            for (int i=maxr, j=minc; i>= minr && counter < totalElements; i--){
                System.out.print(matrix[i][j]+" ");
                counter++;
            }
            minc++;
        }

    }
}
