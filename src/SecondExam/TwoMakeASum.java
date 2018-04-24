package SecondExam;

import java.util.HashSet;
import java.util.Scanner;

public class TwoMakeASum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] numbersStr = in.nextLine().split(" ");
        String[] sumsStr = in.nextLine().split(" ");
        int[] numbers = new int[numbersStr.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(numbersStr[i]);
        }
        int answer = 0;
        for (String aSumsStr : sumsStr) {
            if (twoSum(numbers, Integer.parseInt(aSumsStr))) answer++;
        }
        System.out.println(answer);
    }

    static boolean twoSum(int[] nums, int target) {
        if(nums==null || nums.length<2) return false;
        HashSet<Integer> possible = new HashSet<>();
        for (int num : nums) {
            if (possible.contains(num)) return true;
            else {
                possible.add(target - num);
            }
        }
        return false;
    }
}