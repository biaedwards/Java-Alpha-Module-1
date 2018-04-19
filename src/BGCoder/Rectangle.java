package BGCoder;

import java.util.Scanner;

public class Rectangle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int minArea = n * m;
        int maxArea = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (!isRectangle(m, n, i, j)) continue;
                int area = calculateArea(m, n, i, j);
                maxArea = Math.max(area, maxArea);
                minArea = Math.min(area, minArea);
            }
        }
        System.out.println(minArea);
        System.out.println(maxArea);
    }

    static boolean isRectangle(int m, int n, int i, int j) {
        if (i * (m - i) == j * (n - j)) return true;
        else return false;
    }

    static int calculateArea(int m, int n, int i, int j) {
        int area = n * m - i * j - (m - i) * (n - j);
        return area;
    }
}
