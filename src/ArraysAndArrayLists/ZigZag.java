package ArraysAndArrayLists;

import java.util.Scanner;

public class ZigZag {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        System.out.println(zigZag(N,M));
    }

    static long zigZag(int rows, int cols){
        long sum = 1L;
        for (int i = 0; i < rows;) {
            int dRow = -1;
            for (int j = 1; j < cols; j++) {
                dRow*=-1;
                i+=dRow;
                sum+=getNumber(i,j);
            }
            if(i==rows-1){
                break;
            }
            dRow*=-1;
            for (int j = cols-2; j >= 0; j--) {
                dRow*=-1;
                i+=dRow;
                sum+=getNumber(i,j);
            }
            if(i==rows-1){
                break;
            }
        }
        return sum;
    }

    static long getNumber(int row, int col){
        long value = 3*(row+col)+1;
        return value;
    }
}
