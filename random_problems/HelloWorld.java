package com.sunbeam;

import java.util.ArrayList;
import java.util.Scanner;

class LargeFactorial {
    // NOTE: Please do not modify this function
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int ans[] = largeFactorial(n);
        for (int j : ans)
            System.out.print(j);

    }

    // TODO: Implement this method
    static int[] largeFactorial(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        for(int i=2; i<=n; i++){
            int carry = 0;
            int size = list.size();

            for(int j=0; j<size; j++){
                int ans = i * list.get(j)+ carry;
                int rem = ans%10;
                carry=ans/10;
                list.set(j, rem);
            }

            while(carry!=0){
                list.add(carry%10);
                carry = carry/10;
            }
        }
        int size = list.size();
        ArrayList<Integer> rev = new ArrayList<>();
        for(int i=size-1; i>=0; i--){
            rev.add(list.get(i));
        }
        int[] arr = new int[size];
        for(int i=0; i<size; i++){
            arr[i]= rev.get(i);
        }
        return arr;
    }


}





