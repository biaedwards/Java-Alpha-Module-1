package FirstExam;

import java.util.Scanner;

public class TheGreedyDwarf {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int[][] labyrinth = new int[N][M];
        int startR = 0, startC = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                labyrinth[i][j] = in.nextInt();
                if (labyrinth[i][j] == 0) {
                    startR = i;
                    startC = j;
                }
            }
        }
        goThroughLab(labyrinth, startR, startC);
    }

    static void goThroughLab(int[][] labyrinth, int cRow, int cCol) {
        int coins = 0;
        while (true) {
            int[] x = {0, 0, -1, 1};
            int[] y = {-1, 1, 0, 0};
            int max = 0;
            int tempR = cRow, tempC = cCol;
            for (int i = 0; i < x.length; i++) {
                int nRow = cRow + x[i];
                int nCol = cCol + y[i];
                if (nRow < 0 || nCol < 0 || nRow > labyrinth.length - 1 || nCol > labyrinth[0].length - 1) continue;
                if (labyrinth[nRow][nCol] > max) {
                    max = labyrinth[nRow][nCol];
                    tempR = nRow;
                    tempC = nCol;
                }
            }
            cRow = tempR;
            cCol = tempC;
            if (max == 0) break;
            coins++;
            labyrinth[cRow][cCol]--;
        }
        System.out.println(coins);
    }
}