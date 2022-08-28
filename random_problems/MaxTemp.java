package com.sunbeam;

import java.util.HashMap;
import java.util.Map;

public class MaxTemp {
    static int mostRepeatedTemperature(int n, int arr[]) {
        HashMap<Integer,Integer> frequency=new HashMap<Integer,Integer>();
        int max=0;
        int key=0;
        for(int i=0; i<arr.length; i++){
            if(!frequency.containsKey(arr[i])){
                frequency.put(arr[i],0);
            }
            frequency.put(arr[i],frequency.get(arr[i])+1);
            if(frequency.get(arr[i])>max){
                max= frequency.get(arr[i]);
            }
        }
        for(Map.Entry<Integer, Integer> entry: frequency.entrySet()) {
            if(entry.getValue() == max) {
                key=entry.getKey();
            }
        }
        return key;
    }
    public static void main(String[] args) {
        int arr[] = {-10,11,14,17,4,4,4,17,17,17};
        int max = mostRepeatedTemperature(5,arr);
        System.out.println(max);

    }
}
