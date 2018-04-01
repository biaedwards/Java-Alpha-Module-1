import java.util.Scanner;

public class SymetricArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        boolean[] answers = new boolean[n];
        for (int i = 0; i < n; i++) {
            String[] arr = scan.nextLine().split("\\s");
            if (IsSymetric(arr)) {
                answers[i] = true;
            } else {
                answers[i] = false;
            }
        }
        for(int i=0; i<n; i++){
            if(answers[i]){
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
        }
// way to print easier (isSymmetric is a boolean
//        System.out.println(
//                isSymmetric
//                ? "Yes"
//                       ; No
//        );
    }

    private static boolean IsSymetric(String arr[]) {
        for (int i = 0; i <= arr.length / 2; i++) {
            if (!arr[i].equals(arr[arr.length - i-1])) {
                return false;
            }
        }
        return true;
    }
}
