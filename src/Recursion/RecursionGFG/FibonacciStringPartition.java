package Recursion.RecursionGFG;

import java.util.ArrayList;
import java.util.Scanner;

public class FibonacciStringPartition {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        ArrayList<Integer> fibonacci = new ArrayList<>();
        printFibonacci(input, fibonacci, false);
    }

    static void printFibonacci(String input, ArrayList<Integer> fibonacci, Boolean wasPrinted) {
        if (input.length() == 0 && fibonacci.size() > 2) {
            for (int i = 0; i < fibonacci.size(); i++) {
                System.out.printf("%d ", fibonacci.get(i));
            }
            wasPrinted = true;
            return;
        }
        for (int i = 0; i < input.length(); i++) {
            int toAdd = Integer.parseInt(input.substring(0, i + 1));
            if (fibonacci.size() > 1 && checkFibonacci(toAdd, fibonacci).equals("larger")) continue;
            if (fibonacci.size() > 1 && checkFibonacci(toAdd, fibonacci).equals("smaller")) return;
            fibonacci.add(toAdd);
            printFibonacci(input.substring(i + 1, input.length()), fibonacci, wasPrinted);
            if (wasPrinted) return;
            else {
                fibonacci.remove(fibonacci.size() - 1);
            }
        }
    }

    static String checkFibonacci(int sum, ArrayList<Integer> fibonacci) {
        if (fibonacci.get(fibonacci.size() - 1) + fibonacci.get(fibonacci.size() - 2) == sum) return "equals";
        else if (fibonacci.get(fibonacci.size() - 1) + fibonacci.get(fibonacci.size() - 2) > sum) return "larger";
        return "smaller";
    }
}
