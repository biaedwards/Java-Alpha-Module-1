package Recursion.RecursionGFG;

import java.util.ArrayList;
import java.util.Scanner;

//Given a string, find all possible palindromic partitions of given string.

public class PalindromicPartitionsOfAString {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input = in.nextLine();
        ArrayList<String> palindromes = new ArrayList<>();
        findPalindromes(input, 0, "", palindromes, "");
        palindromes.forEach(System.out::println);
    }
    static void findPalindromes(String input, int startIndex, String current, ArrayList<String> partitions, String partition){
        if(startIndex==input.length()){
            partitions.add(partition);
            return;
        }
        StringBuilder temp=new StringBuilder();
        temp.append(current);
        for (int i = startIndex; i < input.length(); i++) {
           temp.append(input.charAt(i));
            if(isPalinrome(String.valueOf(temp))){
                findPalindromes(input, i+1, "",partitions, partition+temp+" ");
            }
        }
    }

    static boolean isPalinrome(String input){
        if(input.length()==0||input.length()==1){
            return true;
        }
        if(input.charAt(0)==input.charAt(input.length()-1)){
            return isPalinrome(input.substring(1,input.length()-1));
        }
        return false;
    }
}
