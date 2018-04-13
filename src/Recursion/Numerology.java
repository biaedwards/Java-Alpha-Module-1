package Recursion;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Numerology {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String birth = in.nextLine();
        int[] options = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        countOptions(birth, options);
      for(int anOption:options){
          System.out.printf("%d ", anOption);
      }
    }

    static void countOptions(String birth, int[] options) {
        for (int i = 0; i < birth.length() - 1; i++) {
            int a = birth.charAt(i) - 48;
            int b = birth.charAt(i + 1) - 48;
            int combined = (a + b) * (a ^ b) % 10;
            if (birth.length() == 2) {
                options[combined]++;
                return;
            }
            String newBirth = birth.substring(0, i) + combined + birth.substring(i + 2);
            countOptions(newBirth, options);
        }
    }
}
