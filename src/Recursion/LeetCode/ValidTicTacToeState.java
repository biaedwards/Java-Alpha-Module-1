package Recursion.LeetCode;

import java.util.Scanner;

public class ValidTicTacToeState {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] board = in.nextLine().split(",");
        if(isValid(board)) System.out.println("Yes.");
        else System.out.println("No.");
    }

    static boolean isValid(String[] board){
        int x = count(board, 'X');
        int o = count(board, 'O');
        if(o>x) return false;
        if(o+1<x) return false;
        if(hasWon(board, 'X')&&o==x) return false;
        if(hasWon(board, 'O')&&x>o) return false;
        return true;
    }

    static int count(String[] board, char player){
        int count=0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length(); j++) {
                if(board[i].charAt(j)==player) count++;
            }
        }
        return count;
    }

    static boolean hasWon(String[] board, char player){
        //check for horizontal line
        for (int i = 0; i < board.length; i++) {
            if(board[i].charAt(0)==player&&board[i].charAt(1)==player&&board[i].charAt(2)==player) return true;
        }

        //check for vertical line
        for (int j = 0; j < board[0].length(); j++) {
            if(board[0].charAt(j)==player&&board[1].charAt(j)==player&&board[2].charAt(j)==player) return true;
        }

        //check diagonals
        if(board[0].charAt(0)==player&&board[1].charAt(1)==player&&board[2].charAt(2)==player) return true;
        if(board[0].charAt(2)==player&&board[1].charAt(1)==player&&board[2].charAt(0)==player) return true;
        return false;
    }
}
