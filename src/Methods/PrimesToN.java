package Methods;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrimesToN {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n>0){
            printPrimes(n);
        }
    }
    static void printPrimes(int n){
        List<Boolean> isPrime = Stream.generate(() -> true)
                .limit(n+1)
                .collect(Collectors.toList());
        System.out.print("1 ");
        for (int i = 2; i < n+1; i++) {
            if(isPrime.get(i)){
                System.out.printf("%d ",i);
                for (int j = i+i; j < n+1; j+=i) {
                    isPrime.set(j, false);
                }
            }
        }
    }
}
