package Recursion.HackerRank;

import java.util.Scanner;

public class ThePowerSum {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int target = in.nextInt();
        int power = in.nextInt();
        System.out.println(countWays(target, power,target));
    }

    static int countWays(int target, int power, int start){
        if(target==0) return 1;
        int count=0;
        int top = (int) Math.pow(target, 1/(double)power);
        for (int i = Math.min(top, start); i > 0; i--) {
            int temp = (int) Math.pow(i, power);
            if(temp<=target){
                count+=countWays(target-temp, power, i-1);
            }
        }
        return count;
    }
}
