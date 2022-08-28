package com.sunbeam;

public class DiagonalTraversal {
    public static void main(String[] args) {
        int[][] arr = {
                {1,5,7,9,10,11},
                {6,10,12,13,20,21},
                {9,25,29,30,32,41},
                {15,55,59,63,68,70},
                {40,70,79,81,95,105},
                {89,45,6,98,78,65}
        };

        for(int gap = 0; gap<arr.length; gap++){
            for(int i=0, j=gap; j<arr.length; i++, j++){
                System.out.println(arr[i][j]);
            }
        }
    }
}
