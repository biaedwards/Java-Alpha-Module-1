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
        ArrayList<StringBuilder> translated = new ArrayList<>();
        translateMessage(message, codes, translated, new StringBuilder());
        ArrayList<String> translatedSorted = new ArrayList<>();
        for (StringBuilder aTranslated: translated) {
            translatedSorted.add(aTranslated.toString());
        }
        Collections.sort(translatedSorted);
        System.out.println(translated.size());
        for (int i = 0; i <translated.size(); i++) {
            System.out.println(translatedSorted.get(i));
        }
    }

    static void translateMessage(String message, HashMap<String, Character> codes, ArrayList<StringBuilder> translated, StringBuilder translation){
        StringBuilder current = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            current.append(message.charAt(i));
            if(codes.containsKey(String.valueOf(current))){
                translation.append(codes.get(String.valueOf(current)));
                if(i==message.length()-1){
                    StringBuilder answer = new StringBuilder(translation);
                    translated.add(answer);
                    translation.deleteCharAt(translation.length()-1);
                    return;
                }
                translateMessage(message.substring(i+1), codes, translated, translation);
                translation.deleteCharAt(translation.length()-1);
            }
        }
    }
}
