package com.sunbeam;

public class StringC {
    public static String compress(String str) {
        String s = str.charAt(0)+"";
        int count = 1;
        for(int i=1; i< str.length(); i++){
            char curr = str.charAt(i);
            char prev = str.charAt(i-1);

            if(curr == prev){
                count++;
            }else{
                if(count>0){
                    s+=count;
                    count=1;
                }
                s+=curr;
            }
        }
        if(count>0){
            s+=count;
            count = 1;
        }
        return s;
    }
    public static void main(String[] args) {
        String s = "aabccccc";
        String ans = compress(s);
        System.out.print(ans);
    }
}
