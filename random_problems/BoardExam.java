package com.sunbeam;

import java.util.HashSet;

public class BoardExam {
    static int boardExams(int n,String[] arr){
        HashSet<String> set = new HashSet();
        for(int i=0; i<arr.length;i++){
            for(int j=0; j<arr.length; j++){
                if(i != j){
                    if(arr[i].charAt(0) == arr[j].charAt(0) && arr[i].charAt(arr[i].length()-1) == arr[j].charAt(arr[j].length()-1)){
                        set.add(arr[i]);
                    }
                }
            }
        }
        return set.size();
    }
    public static void main(String[] args) {

    }
}
