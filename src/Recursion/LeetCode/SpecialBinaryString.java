package Recursion.LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SpecialBinaryString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String special = in.nextLine();
        System.out.println(makeLargestSpecial(special));
    }

    static String makeLargestSpecial(String special) {
        if (special.length() == 0) return "";
        ArrayList<String> specials = new ArrayList<>();
        int sum = 0;
        int start=0;
        for (int i = 0; i < special.length(); i++) {
            if (special.charAt(i) == '1') sum++;
            else {
                sum--;
                if(sum==0){
                    if(i==special.length()-1&&specials.size()==0)  return "1" + makeLargestSpecial(special.substring(1, special.length() - 1)) + "0";
                    specials.add(makeLargestSpecial(special.substring(start, i+1)));
                    start=i+1;
                }
            }
        }
        Collections.sort(specials, Collections.reverseOrder());
        StringBuilder newSpecial = new StringBuilder();
        for (String s : specials) {
            newSpecial.append(s);
        }
        return String.valueOf(newSpecial);
    }


}
