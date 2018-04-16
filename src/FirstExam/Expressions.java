package FirstExam;

import java.util.Scanner;

public class Expressions {
    public static void main(String[] args){
        Scanner in= new Scanner(System.in);
        String digitsStr = in.nextLine();
        int target = in.nextInt();
        char[] digits = digitsStr.toCharArray();
        int counter = countValidExpressions(digits, target, 0, 0, 0);
        System.out.println(counter);
    }
    
    static int countValidExpressions(char[] digits, int target, int startIndex, int sum, int previous){
        int add=0, subtract =0, multiply=0;
        for (int i = startIndex; i < digits.length; i++) {
            if(i!=startIndex&&digits[startIndex]=='0'){
                break;
            }
            int currentNumber = 0;
            for (int j = startIndex; j <=i ; j++) {
                currentNumber = currentNumber*10+(digits[j]-48);
            }
            int skip = String.valueOf(currentNumber).length();
            int tempSum = sum+currentNumber;
            add += countValidExpressions(digits, target, startIndex+skip, tempSum, currentNumber);
            tempSum = sum-currentNumber;
            subtract += countValidExpressions(digits, target, startIndex+skip,tempSum, -currentNumber);
            tempSum = sum-previous+previous*currentNumber;
            multiply += countValidExpressions(digits, target, startIndex+skip, tempSum, previous*currentNumber);

        }
        if(startIndex>=digits.length){
            if(sum==target) return 1;
            else return 0;
        }
        if(sum==0&&startIndex==0) return add;
        else return add+subtract+multiply;
    }
}
