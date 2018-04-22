package Recursion.RecursionGFG;

import java.util.Scanner;

public class SortedWithAlternating {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] arrStr1 = in.nextLine().split(" ");
        String[] arrStr2 = in.nextLine().split(" ");
        int[] one = new int[arrStr1.length];
        int[] two = new int[arrStr2.length];
        for (int i = 0; i < arrStr1.length; i++) {
            one[i] = Integer.parseInt(arrStr1[i]);
        }
        for (int i = 0; i < arrStr2.length; i++) {
            two[i] = Integer.parseInt(arrStr2[i]);
        }
        getArrays(one, two, 0, 0, "", one[0]);
    }

    static void getArrays(int[] one, int[] two, int oneStart, int twoStart, String array, int previous) {
        if (oneStart == one.length || twoStart == two.length) return;
        for (int i = oneStart; i < one.length; i++) {
            int temp = 0;
            if (one[i] < previous) continue;
            for (int j = twoStart; j < two.length; j++) {
                if (two[j] < one[i]) continue;
                System.out.println(array + one[i] + " " + two[j]);
                getArrays(one, two, i + 1, j + 1, array + one[i] + " " + two[j] + " ", two[j]);
            }
        }
    }
}
