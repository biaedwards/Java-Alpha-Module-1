package Recursion.RecursionGFG;

import java.util.Scanner;

public class StringToInteger {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(getValue(input));
    }
    static int getValue(String input){
        if(input.length()==1){
            int current = Integer.parseInt(input);
            return input.charAt(0)-'0';
        }
        return 10*getValue(input.substring(0,input.length()-1))+(input.charAt(input.length()-1)-'0');
    }
}
