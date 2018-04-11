package ArraysAndArrayLists;

import java.util.Scanner;

public class Slices3D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt();
        int H = in.nextInt();
        int D = in.nextInt();
        int[][] cube = new int[H][W * D];
        in.nextLine();
        for (int i = 0; i < cube.length; i++) {
            String[] tempStr = in.nextLine().split(" ");
            int[] temp = new int[tempStr.length - D + 1];
            int k = 0;
            for (int j = 0; j < temp.length; j++) {
                if (tempStr[k].equals("|")) {
                    k++;
                    j--;
                    continue;
                }
                temp[j] = Integer.parseInt(tempStr[k]);
                k++;
            }
            cube[i] = temp;
        }
        System.out.println(sliceHeight(cube)+sliceDepth(cube,W,D)+sliceWidth(cube, W,D));

    }

    static int sliceHeight(int[][] cube) {
        int options = 0;
        for (int i = 1; i < cube.length; i++) {
            int sum1 = 0, sum2 = 0;
            for (int j = 0; j < i; j++) {
                for (int k = 0; k < cube[0].length; k++) {
                    sum1 += cube[j][k];
                }
            }
            for (int j = i; j < cube.length; j++) {
                for (int k = 0; k < cube[0].length; k++) {
                    sum2 += cube[j][k];
                }
            }
            if (sum1 == sum2) options++;
        }
        return options;
    }

    static int sliceDepth(int[][] cube, int width, int depth) {
        int options = 0;
        for (int i = 1; i < depth; i++) {
            int sum1 = 0, sum2 = 0;
            for (int j = 0; j < i * width; j++) {
                for (int k = 0; k < cube.length; k++) {
                    sum1 += cube[k][j];
                }
            }
            for (int j = i * width; j < cube[0].length; j++) {
                for (int k = 0; k < cube.length; k++) {
                    sum2 += cube[k][j];
                }
            }
            if (sum1 == sum2) options++;
        }
        return options;
    }

    static int sliceWidth(int cube[][], int width, int depth) {
        int options = 0;
        int[] stack = new int[cube[0].length];
        for (int i = 0; i < stack.length; i++) {
            int sum = 0;
            for (int j = 0; j < cube.length; j++) {
                sum+=cube[j][i];
            }
            stack[i] = sum;
        }
        for (int i = 1; i < width; i++) {
            int sum1 = 0, sum2 = 0;
            for (int j = 0; j < i; j++) {
                for (int k = j; k < stack.length; k+=width) {
                    sum1+=stack[k];
                }
            }
            for (int j = i; j < width; j++) {
                for (int k = j; k < stack.length; k+=width) {
                    sum2+=stack[k];
                }
            }
            if (sum1 == sum2) options++;
        }
        return options;
    }
}
