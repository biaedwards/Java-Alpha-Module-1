package FirstExam;

import java.util.Scanner;

public class BitConvert {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] message = in.nextLine().split(",");
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < message.length; i++) {
            int number = Integer.parseInt(message[i]);
            String binEight = toBinary(number);
            if(answer.length()/4%2==0){
                for (int j = 1; j < binEight.length(); j+=2) {
                    answer.append(binEight.charAt(j));
                }
            }
            else{
                for (int j = 0; j < binEight.length(); j+=2) {
                    answer.append(binEight.charAt(j));
                }
            }
        }
        System.out.println(answer);
    }

    static String toBinary(int dec) {
        if (dec == 0) {
            String binaryStr = new String("0");
            return "00000000";
        } else {
            long decCopy = dec;
            int count = 0;
            while (decCopy != 0) {
                decCopy /= 2;
                count++;
            }
            char[] binary = new char[count];
            for (int i = 0; i < count; i++) {
                if (dec % 2 == 0) {
                    binary[count - i - 1] = '0';
                } else {
                    binary[count - i - 1] = '1';
                }
                dec /= 2;
            }
            String binaryStr = new String(binary);
            StringBuilder binEight = new StringBuilder();
            int zeroes = 8-binaryStr.length();
            for (int i = 0; i < zeroes; i++) {
                binEight.append(0);
            }
            binEight.append(binaryStr);
            return String.valueOf(binEight);
        }
    }
}
