import java.util.ArrayList;
import java.util.Scanner;

public class BigNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number1 = in.nextInt();
        int number2 = in.nextInt();
        ArrayList<Integer> num1 = new ArrayList<>();
        ArrayList<Integer> num2 = new ArrayList<>();
        for (int i = 0; i < number1; i++) {
            num1.add(in.nextInt());
        }
        for (int i = 0; i < number2; i++) {
            num2.add(in.nextInt());
        }
        while(num1.size()>num2.size()){
            num2.add(0);
        }
        while(num2.size()>num1.size()){
            num1.add(0);
        }
        ArrayList<Integer> result = new ArrayList<>();
        int remainder = 0;
        for (int i = 0; i < Math.max(number1, number2); i++){
            int put = num1.get(i)+num2.get(i)+remainder;
            result.add(put%10);
            if(put>9){
                remainder = put/10;
            }
            else{
                remainder = 0;
            }
        }
        if(remainder!=0){
            result.add(remainder);
        }
        for (Integer aResult : result) {
            System.out.printf("%d ", aResult);
        }

    }
}
