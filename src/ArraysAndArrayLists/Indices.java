package ArraysAndArrayLists;

import java.util.ArrayList;
import java.util.Scanner;

public class Indices {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = in.nextInt();
        }
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(0);
        int index = 0;
        boolean loop = false;
        int cycle = 0;
        while (true) {
            if (answer.contains(numbers[index])) {
                loop = true;
                cycle = numbers[index];
                break;
            } else if (numbers[index] > numbers.length - 1) {
                break;
            }
            answer.add(numbers[index]);
            index = numbers[index];
        }
        if (!loop) {
            for (Integer anAnswer : answer) {
                System.out.printf("%d ", anAnswer);
            }
        } else {
            for (int i = 0; i < answer.size(); i++) {
                if (answer.get(i) == cycle) {
                    System.out.printf("(%d", answer.get(i));
                } else {
                    System.out.printf(" %d", answer.get(i));
                }
            }
            System.out.print(")");
        }
    }
}
