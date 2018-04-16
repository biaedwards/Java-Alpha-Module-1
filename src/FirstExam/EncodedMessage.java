package FirstExam;

        import java.util.Scanner;

public class EncodedMessage {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        StringBuilder message = new StringBuilder();
        message.append(input);
        decodeMessage(message, 0, 1);
        System.out.println(message);
    }
    static void decodeMessage(StringBuilder message, int startIndex, int repeatCount){
        StringBuilder toRepeat = new StringBuilder();
        for (int i = startIndex; i < message.length(); i++) {
            if(message.charAt(i)=='}'){
                int replaceStart = startIndex-1-String.valueOf(repeatCount).length();
                int replaceEnd = i+1;
                StringBuilder toAdd = new StringBuilder();
                for (int j = 0; j < repeatCount; j++) {
                    toAdd.append(toRepeat);
                }
                message.replace(replaceStart, replaceEnd, String.valueOf(toAdd));
                return;
            }
            if(message.charAt(i)>='a'&&message.charAt(i)<='z'){
                toRepeat.append(message.charAt(i));
            }
            else if(message.charAt(i)>='0'&&message.charAt(i)<='9'){
                int repeater = message.charAt(i)-48;
                while(message.charAt(i+1)>='0'&&message.charAt(i+1)<='9'){
                    repeater = repeater*10+(message.charAt(i+1)-48);
                    i++;
                }
                decodeMessage(message, i+2, repeater);
                i-=String.valueOf(repeater).length();
            }
        }
    }
}
