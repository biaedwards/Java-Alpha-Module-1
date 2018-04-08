package Recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class SolveSudoku {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> sudoku = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            String currentRowString = in.nextLine();
            ArrayList<Integer> currentRow = new ArrayList<>();
            for (int j = 0; j < currentRowString.length(); j++) {
                if (currentRowString.charAt(j) == '-') {
                    currentRow.add(0);
                } else {
                    currentRow.add(currentRowString.charAt(j) - 48);
                }
            }
            sudoku.add(currentRow);
        }
        findSolution(sudoku, 0, 0, false);
    }

    static void findSolution(ArrayList<ArrayList<Integer>> sudoku, int row, int col, boolean foundSolution) {
        for (int i = row; i < sudoku.size(); i++) {
            for (int j = col; j < sudoku.size(); j++) {
                if (sudoku.get(i).get(j) != 0) continue;
                HashSet<Integer> used = getUsed(sudoku, i, j);
                if (used.size() == 10) return;
                for (int k = 1; k < 10; k++) {
                    if (used.contains(k)) continue;
                    sudoku.get(i).set(j, k);
                    findSolution(sudoku, i, j, foundSolution);
                    if (foundSolution) return;
                    sudoku.get(i).set(j, 0);
                }
                if (sudoku.get(i).get(j) == 0) return;
            }
            if (i == 8) {
                for (int k = 0; k < 9; k++) {
                    for (int j = 0; j < 9; j++) {
                        System.out.print(sudoku.get(k).get(j));
                    }
                    System.out.println();
                }
                foundSolution = true;
                return;
            }
            col = 0;
        }
    }

    static HashSet<Integer> getUsed(ArrayList<ArrayList<Integer>> sudoku, int row, int col) {
        HashSet<Integer> used = new HashSet<>();
        used.addAll(sudoku.get(row));
        for (int k = 0; k < sudoku.size(); k++) {
            used.add(sudoku.get(k).get(col));
        }
        for (int i = row / 3 * 3; i < (row / 3 + 1) * 3; i++) {
            for (int j = col / 3 * 3; j < (col / 3 + 1) * 3; j++) {
                used.add(sudoku.get(i).get(j));
            }
        }
        return used;
    }
}
