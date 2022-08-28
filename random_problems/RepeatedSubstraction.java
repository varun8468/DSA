package com.sunbeam;

import java.util.Comparator;
import java.util.PriorityQueue;
class Mycomparator implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2-o1;
    }
}

public class RepeatedSubstraction {
    static int reduceArray(int n, int a[]){
        Mycomparator comp = new Mycomparator();
        PriorityQueue<Integer> q = new PriorityQueue<>(comp);
        for(int i=0; i<a.length; i++){
            q.add(a[i]);
        }
        int count = a.length-1;
        while(count>0){
            int largest = q.poll();
            int sLargest = q.poll();
            int diff = largest - sLargest;
            q.add(diff);
            count--;
        }
        return q.peek();
    }
    public static void main(String[] args) {

        int arr[] = {4, 6, 11, 13, 7};
        int res = reduceArray(5, arr);
        System.out.println(res);
    }
}
