package ArraysAndArrayLists;

import java.util.Arrays;
import java.util.Scanner;

public class NextPermutation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String[] permutationStr = in.nextLine().split(" ");
        int[] permutation = new int[permutationStr.length];
        for (int i = 0; i < permutation.length; i++) {
            permutation[i] = Integer.parseInt(permutationStr[i]);
        }
        int startChange = permutation.length-1;
        while(startChange>0&&permutation[startChange]<permutation[startChange-1]){
            startChange--;
        }
        Arrays.sort(permutation, startChange, permutation.length);
        for (int i = startChange; i < permutation.length; i++) {
            if(permutation[startChange-1]<permutation[i]){
                int swap = permutation[startChange-1];
                permutation[startChange-1]=permutation[i];
                permutation[i]=swap;
                break;
            }
        }
        for(int number:permutation){
            System.out.printf("%d ", number);
        }
    }
}
