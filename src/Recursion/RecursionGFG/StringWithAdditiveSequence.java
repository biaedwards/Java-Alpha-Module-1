package Recursion.RecursionGFG;

import java.util.Scanner;

public class StringWithAdditiveSequence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        findSequences(input, 0, "", 0);
    }

    static void findSequences(String input, int startIndex, String expression, int sum) {
        for (int i = startIndex; i < input.length() - 1; i++) {
            int append = input.charAt(i) - '0';
            int j = i + 1;
            while (j < input.length()) {
                //add
                if (!expression.contains("+")) {
                    findSequences(input, j, expression + append + "+", sum + append);
                } else if (!expression.contains("=")) {
                    findSequences(input, j, expression + append + "=", sum + append);
                } else if (append == sum) {
                    System.out.println(expression + append);
                } else if (append > sum) {
                    return;
                }
                //append
                if (append == 0) break;
                append = append * 10 + input.charAt(j) - '0';
                j++;
            }
            if (expression.contains("=") && append == sum) {
                System.out.println(expression + append);
            }
            if (startIndex != 0) return;
        }
    }
}
