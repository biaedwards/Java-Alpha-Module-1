package ArraysAndArrayLists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SubsetOfSumS {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int S = Integer.parseInt(scan.nextLine());
        String[] tokensString = scan.nextLine().split("\\s");
        int[] tokens = new int[tokensString.length];
        for (int i = 0; i < tokensString.length; i++) {
            tokens[i] = Integer.parseInt(tokensString[i]);
        }
        HashMap<String, Boolean> mem = new HashMap<>();
        if(DP(tokens, S, tokens.length-1, mem)){
            System.out.println("yes");
        } else{
            System.out.println("no");
        }
    }

    static boolean DP(int[] tokens, int sum, int limit, HashMap<String, Boolean> mem){
        String key = sum + ":" + limit;
        boolean toReturn;
        if(mem.containsKey(key)){
            return mem.get(key);
        }  else if(sum==0){
            return true;
        } else if(sum<0){
            return false;
        } else if(limit<0){
            return false;
        } else if(sum<tokens[limit]){
            toReturn = DP(tokens, sum, limit-1, mem);
        } else{
            toReturn = DP(tokens, sum, limit-1, mem)||DP(tokens, sum-tokens[limit], limit-1, mem);
        }
        mem.put(key, toReturn);
        return toReturn;
    }

    private static boolean addMoreNumbers(int[] tokens, int S, int start, int position) {
        if (start == tokens.length - 1) {
            return false;
        }
        ArrayList<Integer> option = new ArrayList<>();
        for (int i = start; i < tokens.length; i++) {
            option.add(tokens[i]);
            int sum = 0;
            for (int j = 0; j < option.size(); j++) {
                sum += option.get(j);
            }
            if (sum == S) {
                return true;
            }
        }
        return addMoreNumbers(tokens, S, start + 1, position + 1);
    }

    private static boolean checkDiff(int tokens[], int S) {
        ArrayList<Integer> diff = new ArrayList<>();
        diff.add(S);
        for (int i = 0; i < tokens.length; i++) {
            if (diff.contains(tokens[i])) {
                return true;
            }
            int currentSize = diff.size();
            for (int j = 0; j < currentSize; j++) {
                int more = diff.get(j) - tokens[i];
                if (!diff.contains(more)) {
                    diff.add(more);
                }
            }
        }
        return false;
    }
}
