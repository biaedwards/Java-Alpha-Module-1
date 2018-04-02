package Methods;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class NumbersTriangle {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        printTriangle(n);
    }

    static void printLine(int i){
        for (int j = 1; j <= i; j++) {
            System.out.printf("%d ",j);
        }
        System.out.println();
    }
    static void printTriangle(int n){
        for (int i = 1; i < n; i++) {
            printLine(i);
        }
        for (int i = n; i > 0; i--) {
            printLine(i);
        }
    }
}
