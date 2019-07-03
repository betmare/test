package amazonTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class amazonMusic {
    private static final Integer PREVIOUS_TIME = 30;
    static ArrayList<Integer> IDsOfSongs(int rideDuration,
                                  ArrayList<Integer> songDurations)
    {
        final int timeMax = rideDuration-PREVIOUS_TIME;
        int maxSum=Integer.MIN_VALUE;
        Integer[] positions = new Integer[2];
        Integer[] durations = new Integer[2];
        for(int i=0; i<songDurations.size();i++) {
            if(songDurations.get(i)>=timeMax) {
                continue;
            } else {
                for(int j=i+1;j<songDurations.size();j++) {
                    int timeTwoSongs = songDurations.get(j)+songDurations.get(i);
                    if(timeTwoSongs<=timeMax) {
                        if(timeTwoSongs>maxSum) {
                            maxSum=timeTwoSongs;
                            durations[0]=songDurations.get(i);
                            durations[1]=songDurations.get(j);
                            positions[0]=i;
                            positions[1]=j;
                        } if(timeTwoSongs==maxSum) {
                            if(songDurations.get(i)>durations[0]||songDurations.get(i)>durations[1]||
                            songDurations.get(j)>durations[0]||songDurations.get(j)>durations[1]) {
                                durations[0]=songDurations.get(i);
                                durations[1]=songDurations.get(j);
                                positions[0]=i;
                                positions[1]=j;
                            }
                        }
                    }
                }
            }
        }
        return new ArrayList<>(Arrays.asList(positions));
    }

    public static void main(String[] args) {
        int rideDuration = 250;
        ArrayList<Integer> songDuration = new ArrayList<>();
        songDuration.add(250);
        songDuration.add(180);
        songDuration.add(40);
        songDuration.add(120);
        songDuration.add(10);
        System.out.println(IDsOfSongs(rideDuration,songDuration));
    }
}
