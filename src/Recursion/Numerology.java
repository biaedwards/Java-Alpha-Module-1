package Recursion;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Numerology {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String birth = in.nextLine();
        int[] options = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        countOptions(birth, options);
        int totalSum = 0;
        for (int option : options) {
           totalSum+=option;
        }
        String[] results = {"You are a very good programmer",
                "You will create very useful programs","You are ugly","You will always depend on an IDE",
                "You like strange languages","You loath science fiction","6? 6 is still a mystery to Pesho","You think class inheritance is magic",
                "You do not mind dynamic typing","You are going to be famous"};

        for (int i=0; i<options.length; i++) {
            double percentage = options[i]*100/totalSum;
            DecimalFormat df = new DecimalFormat("#.#");
            if(percentage==0){
                continue;
            }
            System.out.print(df.format(percentage)+"%   ");
            System.out.println(results[i]);
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
