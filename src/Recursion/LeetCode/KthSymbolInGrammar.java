package Recursion.LeetCode;

import java.util.Scanner;

public class KthSymbolInGrammar {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int index = in.nextInt();
        System.out.println(findSymbol(row, index));
    }

    static int findSymbol(int row, int index) {
        if(row==1) return 0;
        if((index%2==0&&findSymbol(row-1, index/2)==0)||(index%2==1&&findSymbol(row-1, (index+1)/2)==1)) return 1;
        else return 0;
    }
}
