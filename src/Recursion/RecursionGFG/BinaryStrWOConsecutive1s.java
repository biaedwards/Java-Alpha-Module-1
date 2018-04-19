package Recursion.RecursionGFG;

import java.util.Scanner;

public class BinaryStrWOConsecutive1s {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        getStrings(length, false, "");
    }

    static void getStrings(int length, boolean previousWasOne, String current) {
        if (current.length() == length) {
            System.out.println(current);
            return;
        }
        getStrings(length, false, current + "0");
        if (!previousWasOne) getStrings(length, true, current + "1");
    }
}
