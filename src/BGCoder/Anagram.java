package BGCoder;

import java.util.*;

public class Anagram {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] words = in.nextLine().split(" ");

        ArrayList<String> anagrams = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            anagrams.add(sortString(words[i]));
        }
        Collections.sort(anagrams);
        boolean existing = false;
        int counter = 0;
        for (int i = 1; i < anagrams.size(); i++) {
            if (anagrams.get(i).equals(anagrams.get(i - 1))) {
                if (existing) continue;
                counter++;
                existing = true;
            } else {
                existing = false;
            }
        }
        System.out.println(counter);
    }

    static String sortString(String inputString) {
        char tempArray[] = inputString.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }
}
