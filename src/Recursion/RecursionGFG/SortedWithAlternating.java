package Recursion.RecursionGFG;

import java.util.Scanner;

public class SortedWithAlternating {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String[] arrStr1 = in.nextLine().split(" ");
        String[] arrStr2 = in.nextLine().split(" ");
        int[] one = new int[arrStr1.length];
        int[] two = new int[arrStr2.length];
        for (int i = 0; i < arrStr1.length; i++) {
            one[i]=Integer.parseInt(arrStr1[i]);
        }
        for (int i = 0; i < arrStr2.length; i++) {
            two[i]=Integer.parseInt(arrStr2[i]);
        }

    }

    //will use true for one and false for 2
    static void getArrays(int[] one, int[] two, boolean choose){

    }
}
