package ArraysAndArrayLists;

import java.util.ArrayList;
//import java.util.HashMap;
import java.util.Arrays;
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
        System.out.println(isPossible2(tokens, S)? "yes" : "no");
    }

    static boolean isPossible(int[] tokens, int S) {
        boolean[] possible = new boolean[S + 1];
        possible[0] = true;
        for (int i = 0; i < tokens.length; i++) {
            ArrayList<Integer> toAdd = new ArrayList<>();
            for (int j = 0; j < possible.length; j++) {
                if (!possible[j]) continue;
                if (j + tokens[i] > S) continue;
                if (j + tokens[i] == S) return true;
                toAdd.add(j+tokens[i]);
            }
            for (Integer aToAdd : toAdd) {
                possible[aToAdd] = true;
            }
        }
        return false;
    }

    static boolean isPossible2(int[] tokens, int S){
        Arrays.sort(tokens);
        boolean[][] possible = new boolean[S+1][tokens.length+1];
        int x = possible.length;
        int y = possible[0].length;
        for (int i = 0; i < y; i++) {
            possible[0][i]=true;
        }
        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                if(possible[i][j-1]){
                    possible[i][j] = true;
                } else if(i>=tokens[j-1]){
                    possible[i][j] = possible[i-tokens[j-1]][j-1];
                }
            }
        }
        return possible[S][tokens.length];
    }

//    static boolean DP(int[] tokens, int sum, int limit, HashMap<String, Boolean> mem) {
//        String key = sum + ":" + limit;
//        boolean toReturn;
//        if (mem.containsKey(key)) {
//            return mem.get(key);
//        } else if (sum == 0) {
//            return true;
//        } else if (sum < 0) {
//            return false;
//        } else if (limit < 0) {
//            return false;
//        } else if (sum < tokens[limit]) {
//            toReturn = DP(tokens, sum, limit - 1, mem);
//        } else {
//            toReturn = DP(tokens, sum, limit - 1, mem) || DP(tokens, sum - tokens[limit], limit - 1, mem);
//        }
//        mem.put(key, toReturn);
//        return toReturn;
//    }
//
//    private static boolean addMoreNumbers(int[] tokens, int S, int start, int position) {
//        if (start == tokens.length - 1) {
//            return false;
//        }
//        ArrayList<Integer> option = new ArrayList<>();
//        for (int i = start; i < tokens.length; i++) {
//            option.add(tokens[i]);
//            int sum = 0;
//            for (int j = 0; j < option.size(); j++) {
//                sum += option.get(j);
//            }
//            if (sum == S) {
//                return true;
//            }
//        }
//        return addMoreNumbers(tokens, S, start + 1, position + 1);
//    }
//
//    private static boolean checkDiff(int tokens[], int S) {
//        ArrayList<Integer> diff = new ArrayList<>();
//        diff.add(S);
//        for (int i = 0; i < tokens.length; i++) {
//            if (diff.contains(tokens[i])) {
//                return true;
//            }
//            int currentSize = diff.size();
//            for (int j = 0; j < currentSize; j++) {
//                int more = diff.get(j) - tokens[i];
//                if (!diff.contains(more)) {
//                    diff.add(more);
//                }
//            }
//        }
//        return false;
//    }
}
