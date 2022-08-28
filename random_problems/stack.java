package com.sunbeam;

import java.util.Stack;

public class stack {
    private static int postfixExpression(String s) {
        Stack<Integer> stk = new Stack<>();
        for(int i=0; i<s.length(); i++){
            int d = s.charAt(i)-0;
            System.out.println(d);
            if(d>=0 && d<=9){
                int number = d;
                int j=i+1;
                while(s.charAt(j)!=' '){
                    number = number*10+s.charAt(j);
                    j++;
                }
            }else {
                int ans;
                int fe = stk.pop();
                int se = stk.pop();
                if (s.charAt(i) == '+')
                    ans = fe + se;
                else if (s.charAt(i) == '-')
                    ans = fe - se;
                else ans = fe * se;

                stk.push(ans);
                i = i+1;
            }


        }

        return stk.peek();
    }
    public static void main(String[] args) {
        String s = "2 3 +";
        int val = postfixExpression(s);
        System.out.println(val);
    }


}
