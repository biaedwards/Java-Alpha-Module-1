package Recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Permutations {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashSet<Integer> used = new HashSet<>();
        ArrayList<Integer> perm = new ArrayList<>();
        printPermutations(n, used, perm);
    }
    static void printPermutations(int n, HashSet<Integer> used, ArrayList<Integer> perm){
        for(int i=1; i<n+1; i++){
            if(used.contains(i)){
                continue;
            }
            used.add(i);
            perm.add(i);
            printPermutations(n, used, perm);
        }
        if(perm.size()==n){
            perm.forEach(System.out::print);
            System.out.println();
        }
        if(used.size()>0){
            used.remove(perm.get(perm.size()-1));
            perm.remove(perm.size()-1);
        }
    }
}
