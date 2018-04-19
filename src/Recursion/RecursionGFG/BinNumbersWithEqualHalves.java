package Recursion.RecursionGFG;

import java.util.ArrayList;
import java.util.Scanner;

public class BinNumbersWithEqualHalves {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int length = in.nextInt();
        for (int i = 0; i < length/2; i++) {
            ArrayList<String> combos = new ArrayList<>();
            getSumCombos(length/2, i,combos, "",0);
            varyCombos(length, combos, "");
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
        if (currentVariation.length() == length) {
            System.out.println(currentVariation);
            return;
        } else if(length%2==1&&currentVariation.length()==length/2){
            varyCombos(length, combos, currentVariation + "0");
            varyCombos(length, combos, currentVariation + "1");
            return;
        }
        for (int i = 0; i < combos.size(); i++) {
            varyCombos(length, combos, currentVariation + combos.get(i));
        }
    }
}
