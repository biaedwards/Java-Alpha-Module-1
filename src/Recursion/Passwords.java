package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class Passwords {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String moves = in.next();
        int target = in.nextInt();
        getTargetPass(moves, target, "", 1, 9, new ArrayList<Integer>());
    }


    static void getTargetPass(String moves, int target, String currentPass, int startValue, int endValue, ArrayList<Integer> counter) {
        if (isZeroAnOption(moves, currentPass)) {
            if (currentPass.length() == moves.length()) {
                counter.add(1);
                if (counter.size() == target) {
                    System.out.println(currentPass + 0);
                    return;
                }
            } else {
                StringBuilder equalsCounter = new StringBuilder();
                equalsCounter.append(0);
                while (moves.length() > currentPass.length() + equalsCounter.length() - 1 && moves.charAt(currentPass.length() + equalsCounter.length() - 1) == '=') {
                    equalsCounter.append(0);
                }
                if (currentPass.length() + equalsCounter.length() > moves.length()) {
                    counter.add(1);
                    if (counter.size() == target) {
                        System.out.println(currentPass + equalsCounter);
                        return;
                    }
                } else if (moves.charAt(currentPass.length() + equalsCounter.length() - 1) == '<') {
                    getTargetPass(moves, target, currentPass + equalsCounter, 1, 9, counter);
                }
            }
        }
        for (int i = startValue; i <= endValue; i++) {
            if (currentPass.length() == moves.length()) {
                counter.add(1);
                if (counter.size() == target) {
                    System.out.println(currentPass + i);
                    return;
                }
                continue;
            }
            StringBuilder equalsCounter = new StringBuilder();
            equalsCounter.append(i);
            while (moves.length() > currentPass.length() + equalsCounter.length() - 1 && moves.charAt(currentPass.length() + equalsCounter.length() - 1) == '=') {
                equalsCounter.append(i);
            }
            if (currentPass.length() + equalsCounter.length() > moves.length()) {
                counter.add(1);
                if (counter.size() == target) {
                    System.out.println(currentPass + equalsCounter);
                    return;
                }
            } else if (moves.charAt(currentPass.length() + equalsCounter.length() - 1) == '>') {
                getTargetPass(moves, target, currentPass + equalsCounter, i + 1, 9, counter);
                if (counter.size() >= target) return;
            } else if (moves.charAt(currentPass.length() + equalsCounter.length() - 1) == '<') {
                getTargetPass(moves, target, currentPass + equalsCounter, 1, i - 1, counter);
                if (counter.size() >= target) return;
            }
        }
    }

    static boolean isZeroAnOption(String moves, String currentPass) {
        if (currentPass.length() == 0) return true;
        if (moves.charAt(currentPass.length() - 1) == '>' && currentPass.charAt(currentPass.length() - 1) != '0')
            return true;
        if (moves.charAt(currentPass.length() - 1) == '=' && currentPass.charAt(currentPass.length() - 1) == '0')
            return true;
        return false;
    }
}
