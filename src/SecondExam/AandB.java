package SecondExam;

import java.util.Arrays;
import java.util.Scanner;

public class AandB {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int A = in.nextInt();
        int B = in.nextInt();
        int[] nums = {A,B};
        Arrays.sort(nums);
        printVariations(N, nums, "");
    }

    static void printVariations(int rank, int[] nums, String currentVar){
        if(currentVar.length()==rank){
            System.out.println(currentVar);
            return;
        }
        for (int num : nums) {
            printVariations(rank, nums, currentVar + num);
        }
    }
}
