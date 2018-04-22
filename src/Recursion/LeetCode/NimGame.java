package Recursion.LeetCode;

import java.util.Scanner;

public class NimGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int stones = in.nextInt();
        if (canWin(stones)) System.out.println("yes");
        else System.out.println("no");
    }

    static boolean canWin(int stones) {
        return (stones % 4 != 0);
    }
}
