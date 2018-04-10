package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class GirlsGoneWild2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //will use tops and bottoms instead of shirts and skirts
        int tops = in.nextInt();
        in.nextLine();
        String bottoms = sortString(in.nextLine());
        int girls = in.nextInt();
        ArrayList<int[]> topsCombinations = new ArrayList<>();
        getCombinations(tops, 0, 0, girls, new int[girls], topsCombinations);
        ArrayList<char[]> bottomsVariations = new ArrayList<>();
        getVariations(new HashSet<>(), bottoms, 0, girls, new char[girls], bottomsVariations);
        String[] answer = new String[topsCombinations.size()*bottomsVariations.size()];
        System.out.println(answer.length);
        int start=0;
        for (int[] topCombination : topsCombinations) {
            for (char[] bottomVariation : bottomsVariations) {
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < bottomVariation.length; i++) {
                    temp.append(String.valueOf(topCombination[i]) + bottomVariation[i]+'-');
                }
                temp.deleteCharAt(temp.length()-1);
                answer[start]=temp.toString();
                start++;
            }
        }
        Arrays.sort(answer);
        for(String anAnswer:answer){
            System.out.println(anAnswer);
        }
    }

    static void getVariations(HashSet<Integer> used, String options, int index, int rank, char[] variation, ArrayList<char[]> variations) {
        if (index == rank) {
            char[] temp = variation.clone();
            variations.add(temp);
            return;
        }
        for (int i = 0; i < options.length(); i++) {
            if (i > 0 && options.charAt(i) == options.charAt(i - 1) && !used.contains(i - 1)) continue;
            if (used.contains(i)) continue;
            variation[index] = options.charAt(i);
            used.add(i);
            getVariations(used, options, index + 1, rank, variation, variations);
            used.remove(i);
        }
    }

    static void getCombinations(int max, int current, int index, int rank, int[] combination, ArrayList<int[]> combinations) {
        if (index == rank) {
            int[] temp = combination.clone();
            combinations.add(temp);
            return;
        }
        for (int i = current; i < max; i++) {
            combination[index] = i;
            getCombinations(max, i + 1, index + 1, rank, combination, combinations);
        }
    }

    static String sortString(String inputString) {
        char tempArray[] = inputString.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }
}
