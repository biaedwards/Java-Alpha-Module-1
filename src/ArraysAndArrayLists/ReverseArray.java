import java.util.Scanner;

public class ReverseArray {
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        String[] arr = scan.nextLine().split("\\s");
        for(int i=arr.length-1; i>=0; i--){
            if(i==0){
                System.out.print(arr[i]);
            }
            else{
                System.out.printf(arr[i]+", ");
            }
        }
    }
}
