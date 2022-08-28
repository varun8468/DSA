package com.sunbeam;

public class Tesla {
    static int[] tesla(int n,int[] arr){
        int speed = 1500;
        int maxSpeed = 0;
        int[] newArr = new int[2];
        for (int i=0; i<n; i++){
            speed = speed + arr[i];
            if(maxSpeed < speed){
                maxSpeed = speed;
            }
        }
        newArr[0] = maxSpeed;
        newArr[1] = speed;
        return newArr;
    }
    public static void main(String[] args) {
        int[] diffs = {100, -200, 350, 100, -600};
        int n = diffs.length;
        int[] ans=tesla(n,diffs);
        System.out.println(ans[0]+" "+ans[1]);
    }
}
