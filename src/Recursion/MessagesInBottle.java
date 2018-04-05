package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class MessagesInBottle {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String message = in.nextLine();
        String cipher = in.nextLine();
        HashMap<String, Character> codes = new HashMap<>();
        for (int i = 0; i < cipher.length(); i++) {
            if(cipher.charAt(i)>='A'&&cipher.charAt(i)<='Z'){
                int j=i+1;
                StringBuilder code = new StringBuilder();
                while(cipher.charAt(j)>='0'&&cipher.charAt(j)<='9'){
                    code.append(cipher.charAt(j));
                    j++;
                    if(j>=cipher.length()){
                        break;
                    }
                }
                codes.put(String.valueOf(code), cipher.charAt(i));
                i = j-1;
            }
        }
        ArrayList<String> translated = new ArrayList<>();
        translateMessage(message, codes, translated, new String());
        Collections.sort(translated);
        System.out.println(translated.size());
        for (int i = 0; i <translated.size(); i++) {
            System.out.println(translated.get(i));
        }
    }

    static void translateMessage(String message, HashMap<String, Character> codes, ArrayList<String> translated, String translation){
        if(message.length()==0){
            translated.add(translation);
            return;
        }
        for (int i = 0; i < message.length(); i++) {
            String current = message.substring(0, i+1);
            if(codes.containsKey(current)){
                translateMessage(message.substring(i+1), codes, translated, translation+codes.get(current));
            }
        }
    }
}
