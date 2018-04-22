package Recursion.LeetCode;

import java.util.Arrays;
import java.util.Scanner;

public class PartitionToKEqualSumSubsets {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] numbersStr = in.nextLine().split(" ");
        int k = in.nextInt();
        int[] numbers = new int[numbersStr.length];
        for (int i = 0; i < numbersStr.length; i++) {
            numbers[i] = Integer.parseInt(numbersStr[i]);
        }
        if (isPossible(k, numbers)) System.out.println("Yes.");
        else System.out.println("No.");
    }

    static boolean isPossible(int k, int[] numbers) {
        int totalSum = Arrays.stream(numbers).sum();
        if (totalSum % k != 0) return false;
        int target = totalSum / k;
        Arrays.sort(numbers);
        if (numbers[numbers.length - 1] > target) return false;
        int top = numbers.length - 1;
        while (numbers[top] == target) {
            top--;
            k--;
        }
        return search(new int[k], top, numbers, target);
    }

    static boolean search(int[] groups, int top, int[] numbers, int target) {
        if (top < 0) return true;
        int toAdd = numbers[top];
        for (int i = 0; i < groups.length; i++) {
            if (groups[i] + toAdd <= target) {
                groups[i] += toAdd;
                if (search(groups, top - 1, numbers, target)) return true;
                groups[i] -= toAdd;
            }
        }
        return false;
    }
}
