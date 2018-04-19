package Recursion.RecursionGFG;

import java.util.Scanner;

public class SubstringsWithSameStartAndEndChars {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(countSubstrings(input) + input.length());
    }

    static int countSubstrings(String input) {
        int counter = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.substring(i + 1, input.length()).contains(input.substring(i, i + 1))) {
                for (int j = i + 1; j < input.length(); j++) {
                    if (input.charAt(j) == input.charAt(i)) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }
}
