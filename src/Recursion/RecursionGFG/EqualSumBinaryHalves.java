package Recursion.RecursionGFG;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class EqualSumBinaryHalves {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for (int i = 0; i < N + 1; i++) {
            ArrayList<String> combos = new ArrayList<>();
            getSumCombos(N, i, combos, "", 0);
            varyCombos(N, combos, "");
        }
    }

    static void getSumCombos(int length, int sum, ArrayList<String> combos, String currentCombo, int tempSum) {
        if (currentCombo.length() == length) {
            if (tempSum == sum) {
                combos.add(currentCombo);
            }
            return;
        }
        for (int i = 0; i < 2; i++) {
            if (tempSum + i <= sum) {
                tempSum += i;
                getSumCombos(length, sum, combos, currentCombo + i, tempSum);
            }
        }
    }

    static void varyCombos(int length, ArrayList<String> combos, String currentVariation) {
        if (currentVariation.length() == (2 * length)) {
            System.out.println(currentVariation);
            return;
        }
        for (int i = 0; i < combos.size(); i++) {
            varyCombos(length, combos, currentVariation + combos.get(i));
        }
    }
}
