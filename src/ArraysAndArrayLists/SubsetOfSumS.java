package ArraysAndArrayLists;

import java.util.ArrayList;
import java.util.Scanner;

public class SubsetOfSumS {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int S = Integer.parseInt(scan.nextLine());
        String[] tokensString = scan.nextLine().split("\\s");
        int[] tokens = new int[tokensString.length];
        for (int i = 0; i < tokensString.length; i++) {
            tokens[i] = Integer.parseInt(tokensString[i]);
        }

        if (checkDiff(tokens, S)) {
//        int start = 0;
//        if (addMoreNumbers(tokens, S, start, 0)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

    }

    private static boolean addMoreNumbers(int[] tokens, int S, int start, int position) {
        if (start == tokens.length - 1) {
            return false;
        }
        ArrayList<Integer> option = new ArrayList<>();
        for (int i = start; i < tokens.length; i++) {
            option.add(tokens[i]);
            int sum = 0;
            for (int j = 0; j < option.size(); j++) {
                sum += option.get(j);
            }
            if (sum == S) {
                return true;
            }
        }
        return addMoreNumbers(tokens, S, start + 1, position + 1);
    }

    private static boolean checkDiff(int tokens[], int S) {
        ArrayList<Integer> diff = new ArrayList<>();
        diff.add(S);
        for (int i = 0; i < tokens.length; i++) {
            if (diff.contains(tokens[i])) {
                return true;
            }
            int currentSize = diff.size();
            for (int j = 0; j < currentSize; j++) {
                int more = diff.get(j) - tokens[i];
                if (!diff.contains(more)) {
                    diff.add(more);
                }
            }
        }
        return false;
    }
}
