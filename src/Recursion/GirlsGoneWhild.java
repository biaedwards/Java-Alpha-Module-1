package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class GirlsGoneWhild {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //will use tops and bottoms instead of shirts and skirts
        int tops = in.nextInt();
        in.nextLine();
        String bottoms = sortString(in.nextLine());
        int girls = in.nextInt();
        boolean[][] outfits = new boolean[tops][bottoms.length()];
        ArrayList<String> allCombinations = new ArrayList<>();
        mixAndMatch(bottoms, girls - 1, outfits, "", allCombinations, 0, new HashSet<>(), new HashSet<>());
        System.out.println(allCombinations.size());
        allCombinations.forEach(System.out::println);
    }

    static void mixAndMatch(String bottoms, int girlsLeft, boolean[][] outfits, String allOutfits, ArrayList<String> allCombinations, int startShirt, HashSet<Integer> unusableRows, HashSet<Integer> unusableCols) {
        for (int i = startShirt; i < outfits.length; i++) {
            for (int j = 0; j < outfits[0].length; j++) {
                if (j > 0 && bottoms.charAt(j) == bottoms.charAt(j - 1) && !unusableCols.contains(j - 1)) continue;
                if (outfits[i][j] || unusableRows.contains(i) || unusableCols.contains(j)) continue;
                outfits[i][j] = true;
                unusableRows.add(i);
                unusableCols.add(j);
                String currentOutfit = String.valueOf(i) + bottoms.charAt(j);
                if (girlsLeft == 0) {
                    allCombinations.add(allOutfits + currentOutfit);
                    outfits[i][j] = false;
                    unusableRows.remove(i);
                    unusableCols.remove(j);
                    continue;
                }
                mixAndMatch(bottoms, girlsLeft - 1, outfits, allOutfits + currentOutfit + '-', allCombinations, i + 1, unusableRows, unusableCols);
                outfits[i][j] = false;
                unusableRows.remove(i);
                unusableCols.remove(j);
            }
        }
    }

    static String sortString(String inputString) {
        char tempArray[] = inputString.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }
}