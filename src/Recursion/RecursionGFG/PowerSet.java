package Recursion.RecursionGFG;

import java.util.Scanner;

public class PowerSet {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        getPowerSet(input, "", 0);
    }

    static void getPowerSet(String input, String currentSet, int start) {
        if (currentSet.length() > 0) {
            System.out.printf("%s ", currentSet);
        }
        for (int i = start; i <= input.length(); i++) {
            if (i == input.length()) return;
            getPowerSet(input, currentSet + input.charAt(i), i + 1);
        }
    }
}
