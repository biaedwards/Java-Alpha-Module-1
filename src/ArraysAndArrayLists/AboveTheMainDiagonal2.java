import java.math.BigInteger;
import java.util.Scanner;

public class AboveTheMainDiagonal2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        BigInteger startValue = BigInteger.valueOf(1);
        BigInteger sum = BigInteger.valueOf(0);
        for (int i = 0; i < size; i++) {
            BigInteger currentValue;
            currentValue = startValue;
            for (int j = 0; j <= i; j++) {
                sum = sum.add(currentValue);
                currentValue = currentValue.multiply(BigInteger.valueOf(2));
            }
            startValue = startValue.multiply(BigInteger.valueOf(2));
        }
        System.out.println(sum);
    }
}
