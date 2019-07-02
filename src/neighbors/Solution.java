package neighbors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static List<Integer> cellCompete(int[] states, int days)
    {
        for(int i= 0; i < days; i++) {
            List<Integer> previousStates = new ArrayList<>();
            Collections.addAll(previousStates, Arrays.stream(states).boxed().toArray(Integer[]::new));
            for (int j=0;j< states.length; j++) {
                if(j==0 && j+1<states.length ) {
                    states[j]=previousStates.get(j+1)==0?0:1;
                }else if(j==states.length-1) {
                    states[j]=previousStates.get(j-1)==0?0:1;
                }else if(j<states.length && previousStates.get(j-1)== previousStates.get(j+1)) {
                    states[j]=0;
                } else {
                    states[j]=1;
                }
            }
        }
        return Arrays.stream(states).boxed().collect(Collectors.toList());
    }
    public static void main(String[] args) {
        int days = 1;
        int[] states = {1, 0, 0 , 0, 0, 1, 0, 0};
        List<Integer> finalStates =cellCompete(states,days);
        for (Integer finalState: finalStates) {
            System.out.print(finalState+" ");
        }

    }
}
