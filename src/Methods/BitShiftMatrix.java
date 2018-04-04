package Methods;

import java.math.BigInteger;
import java.util.Scanner;

public class BitShiftMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = scan.nextInt();
        int cols = scan.nextInt();
        int moves = scan.nextInt();
        int[] codes = new int[moves];
        for (int i = 0; i < codes.length; i++) {
            codes[i] = scan.nextInt();
        }
        boolean[][] matrix = new boolean[rows][cols];
        matrix[rows-1][0] = true;
        BigInteger sum = new BigInteger("1");
        int coef = Math.max(rows, cols);
        int posR = rows - 1, posC = 0;
        BigInteger current = BigInteger.valueOf(1);
        for (int i = 0; i < codes.length; i++) {
            int targetR = codes[i]/coef;
            int targetC = codes[i]%coef;
            if (targetC > posC) {
                for (int c = posC + 1; c <= targetC; c++) {
                    posC = c;
                    current = current.multiply(BigInteger.valueOf(2));
                    if (matrix[posR][c]) continue;
                    sum = sum.add(current);
                    matrix[posR][c] = true;
                }
            } else {
                for (int c = posC-1; c >= targetC; c--) {
                    posC = c;
                    current = current.divide(BigInteger.valueOf(2));
                    if (matrix[posR][c]) continue;
                    sum = sum.add(current);
                    matrix[posR][c] = true;
                }
            }
            if (targetR > posR) {
                for (int r = posR+1; r <= targetR; r++) {
                    posR = r;
                    current = current.divide(BigInteger.valueOf(2));
                    if (matrix[r][posC]) continue;
                    sum = sum.add(current);
                    matrix[r][posC] = true;
                }
            } else {
                for (int r = posR-1; r >= targetR; r--) {
                    posR = r;
                    current = current.multiply(BigInteger.valueOf(2));
                    if (matrix[r][posC]) continue;
                    sum = sum.add(current);
                    matrix[r][posC] = true;
                }
            }
        }
        System.out.println(sum);
    }
}
