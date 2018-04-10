package ArraysAndArrayLists;

import java.util.Scanner;

public class Bounce {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        System.out.println(findPathSum(N , M ));
    }

    static long findPathSum(int N, int M) {
       int row = 1;
       int col = 1;
       int dRow = 1;
       int dCol = 1;
       if(N==1||M==1){
           return getValue(0,0);
       }
       long sum = getValue(0,0);
       while(!atCorner(row, col, N, M)){
           sum+=getValue(row, col);
           int nextRow = row+dRow;
           int nextCol = col+dCol;
           if(nextRow<0||nextRow>N-1){
               dRow*= -1;
           }
           if(nextCol<0||nextCol>M-1){
               dCol*=-1;
           }
           row += dRow;
           col+= dCol;
       }
       return sum+getValue(row,col);
    }

    static long getValue(int row, int col){
        int power = row+col;
        return (long) Math.pow(2,power);
    }
    static boolean atCorner(int row, int col, int rows, int cols){
        return ((row==0||row==rows-1) && (col==0||col==cols-1) );
    }
}
