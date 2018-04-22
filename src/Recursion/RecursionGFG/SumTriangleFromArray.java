package Recursion.RecursionGFG;

import java.util.ArrayList;
import java.util.Scanner;

public class SumTriangleFromArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] input = in.nextLine().split(" ");
        ArrayList<Integer> base = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            base.add(Integer.parseInt(input[i]));
        }
        printTriangle(base);
    }

    static void printTriangle(ArrayList<Integer> base) {
        if (base.size() == 0) return;
        ArrayList<Integer> topRow = new ArrayList<>();
        for (int i = 0; i < base.size()-1; i++) {
            topRow.add(base.get(i)+base.get(i+1));
        }
        printTriangle(topRow);
        for (Integer aNumber : base) {
            System.out.printf("%d ", aNumber);
        }
        System.out.println();
    }
}
