package ArraysAndArrayLists;

import java.math.BigInteger;
import java.util.Scanner;

public class NFactorial {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        BigInteger sum = BigInteger.valueOf(1);
        for (int i = 1; i <=n; i++) {
            sum = sum.multiply(BigInteger.valueOf(i));
        }
        System.out.println(sum);
    }
}
