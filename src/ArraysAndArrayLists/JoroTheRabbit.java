import java.util.ArrayList;
import java.util.Scanner;

public class JoroTheRabbit {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] numbersString = in.nextLine().split(", ");
        int[] numbers = new int[numbersString.length];
        for(int i=0; i<numbersString.length; i++){
            numbers[i] = Integer.parseInt(numbersString[i]);
        }

        int currentMax = 1;

        //creating a loop to keep track of the length of jump
        for(int i=1; i<numbers.length; i++){

            //creating a loop to keep track of starting positions for jumps - it goes through the whole numbers[]
            for(int j=0; j<numbers.length; j++){

                //creating an array to keep track of whether a position has been visited only if it's possible
                if(numbers.length%i==0){
                    boolean[] isVisited = new boolean[numbers.length];
                    for(int x = 0; x<isVisited.length; x++){
                        isVisited[x]=false;
                    }
                    //start and next are the positions, since they change and we don't want to loose track of the initial one held in j
                    int start = j;
                    int next = start+i;

                    //check if next doesn't go out of bounds
                    if(next>=numbers.length){
                        next = next-numbers.length;
                    }

                    //starting to count the jumps & making sure positions haven't been previously visited
                    int count = 1;
                    while(numbers[next]>numbers[start] && !isVisited[next] && !isVisited[start]){
                        //insreasing the count and marking position as visited
                        count++;
                        isVisited[start] = true;

                        //setting the next jumping positions
                        start=next;
                        next+=i;

                        //again ckecking if next isn't out of bounds
                        if(next>=numbers.length){
                            next = next-numbers.length;
                        }
                    }
                    //when we have finished jumping we update the maximum jumps for the jump length if needed
                    if(currentMax<count){
                        currentMax = count;
                    }
                }
                else{
                    //start and next are the positions, since they change and we don't want to loose track of the initial one held in j
                    int start = j;
                    int next = start+i;

                    //check if next doesn't go out of bounds
                    if(next>=numbers.length){
                        next = next-numbers.length;
                    }

                    //starting to count the jumps & making sure positions haven't been previously visited
                    int count = 1;
                    while(numbers[next]>numbers[start]){
                        //insreasing the count and marking position as visited
                        count++;

                        //setting the next jumping positions
                        start=next;
                        next+=i;

                        //again ckecking if next isn't out of bounds
                        if(next>=numbers.length){
                            next = next-numbers.length;
                        }
                    }
                    //when we have finished jumping we update the maximum jumps for the jump length if needed
                    if(currentMax<count){
                        currentMax = count;
                    }
                }
            }
        }
        System.out.println(currentMax);
    }
}
