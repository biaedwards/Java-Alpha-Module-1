package BGCoder;

import java.util.Scanner;

public class JoroTheNaughty {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rows = in.nextInt();
        int cols = in.nextInt();
        int jumpNumber = in.nextInt();
        int[] start = new int[2];
        for (int i = 0; i < start.length; i++) {
            start[i] = in.nextInt();
        }
        int[][] jumps = new int[jumpNumber][2];
        for (int i = 0; i < jumps.length; i++) {
            for (int j = 0; j < jumps[0].length; j++) {
                jumps[i][j] = in.nextInt();
            }
        }
        int[][] playground = new int[rows][cols];
        int temp = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                playground[i][j] = temp;
                temp++;
            }
        }
        escape(rows, cols, start, jumps, playground);
    }

    static void escape(int rows, int cols, int[] start, int[][] jumps, int[][] playground) {
        int sum = playground[start[0]][start[1]];
        playground[start[0]][start[1]] = 0;
        for (int i = 0; i < jumps.length; i++) {
            start[0] += jumps[i][0];
            start[1] += jumps[i][1];
            if (start[0] >= rows || start[1] >= cols || start[0] < 0 || start[1] < 0) {
                System.out.println("escaped " + sum);
            }
            if (playground[start[0]][start[1]] == 0) {
                System.out.println("caught " + sum);
            }
            sum += playground[start[0]][start[1]];
            playground[start[0]][start[1]] = 0;
            if (i == jumps.length - 1) i = -1;
        }
    }
}
