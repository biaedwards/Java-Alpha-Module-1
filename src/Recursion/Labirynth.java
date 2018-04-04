package Recursion;

import java.util.Scanner;

public class Labirynth {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        int M = Integer.parseInt(in.nextLine());
        char[][] lab = new char[N][M];
        //x - walls of the labyrinth; ' ' - empty positions; s - start; f - finish; _ - passed
        int startR = 0, startC = 0, finishR = 0, finishC = 0;
        for (int row = 0; row < lab.length; row++) {
            String input = in.nextLine();
            for (int col = 0; col < input.length(); col++) {
                lab[row][col] = input.charAt(col);
                if (input.charAt(col) == 'S') {
                    startR = row;
                    startC = col;
                } else if (input.charAt(col) == 'F') {
                    finishR = row;
                    finishC = col;
                }
            }
        }
        findPath(lab, startR, startC, finishR, finishC);
    }

    static void findPath(char[][] lab, int startR, int startC, int finishR, int finishC) {
        int[] directionsR = {0, 1, 0, -1};
        int[] directionsC = {-1, 0, 1, 0};
        for (int dir = 0; dir < directionsR.length; dir++) {
            int currentR = startR+directionsR[dir];
            int currentC = startC + directionsC[dir];
            if(currentR>=lab.length||currentC>=lab[0].length||currentR<0||currentC<0){
                continue;
            }
            if (lab[currentR][currentC] != ' ' && lab[currentR][currentC] != 'F') {
                continue;
            }
            if (currentR == finishR && currentC == finishC) {
                System.out.println();
                for (int row = 0; row < lab.length; row++) {
                    for (int col = 0; col < lab[0].length; col++) {
                        System.out.printf(" %c ",lab[row][col]);
                    }
                    System.out.println();
                }
                return;
            }
            lab[currentR][currentC] = '_';
            findPath(lab, currentR, currentC, finishR, finishC);
            lab[currentR][currentC] = ' ';
        }
    }
}
