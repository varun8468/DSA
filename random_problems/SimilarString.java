package com.sunbeam;

import java.util.HashMap;

public class SimilarString {
    static String similarString(int n, int m, String s, String t, int k) {
        HashMap<Character, Integer> firstMap = new HashMap<>();
        HashMap<Character, Integer> secondMap = new HashMap<>();

        char[] firstStr = s.toCharArray();
        char[] secondStr = t.toCharArray();
        for(char c : firstStr){
            if(firstMap.containsKey(c)){
                firstMap.put(c, firstMap.get(c)+1);
            }else{
                firstMap.put(c,1);
            }
        }
        for(char c : secondStr){
            if(secondMap.containsKey(c)){
                secondMap.put(c, secondMap.get(c)+1);
            }else{
                secondMap.put(c,1);
            }
        }

        if(firstMap.size()>secondMap.size()){
            for (Character key : firstMap.keySet()) {
                if(secondMap.containsKey(key)){
                    if(Math.abs(firstMap.get(key)-secondMap.get(key))>k){
                        return "No";
                    }
                }
            }
        }else{
            for (Character key : secondMap.keySet()) {
                if(firstMap.containsKey(key)){
                    if(Math.abs(firstMap.get(key)-secondMap.get(key))>k){
                        return "No";
                    }
                }
            }
        }
        return "Yes";


    }
    public static void main(String[] args) {
       String res = similarString(5, 3, "aaabc", "abc", 2);
        System.out.println(res);
    }
}
