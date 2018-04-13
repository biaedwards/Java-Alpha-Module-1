package Recursion.RecursionGFG;

import java.util.ArrayList;
import java.util.Scanner;

//Given a set of characters and a positive integer k, print all possible strings of length k that can be formed from the given set.
//        Input:
//        set[] = {'a', 'b'}, k = 3
//
//        Output:
//        aaa
//        aab
//        aba
//        abb
//        baa
//        bab
//        bba
//        bbb
//
//
//        Input:
//        set[] = {'a', 'b', 'c', 'd'}, k = 1
//        Output:
//        a
//        b
//        c
//        d

public class StringsSetsOfGivenLength {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input = in.nextLine();
        ArrayList<Character> characters = new ArrayList<>();
        int length = 0;
        for (int i = 10; i < input.length(); i+=5) {
            if(input.charAt(i) >='a'&&input.charAt(i)<='z' ){
                characters.add(input.charAt(i));
            }
            if(input.charAt(i+2)=='}'){
                length = Integer.parseInt(input.substring(i+9, input.length()));
                break;
            }
        }
        printSets(characters,length,"");
    }

    static void printSets(ArrayList<Character> characters, int length, String current){
        if(current.length()==length){
            System.out.println(current);
            return;
        }
        for (int i = 0; i < characters.size(); i++) {
            printSets(characters,length,current+characters.get(i));
        }
    }
}
