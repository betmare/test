package arrays;

import java.util.*;
import java.util.stream.Collectors;

public class MinimumSwaps {

    static int minimumSwaps(int[] arr) {
        int minimumSwaps = 0;

        for(int i=0;i<arr.length-1;i++) {
            int j=i;
            while(i+1!=arr[j]) {
                j++;
            }
            int temp = arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            minimumSwaps++;
        }
        return minimumSwaps;
    }
    public static void main(String[] args) {
        int[] arr = {4,3,1,2};
        System.out.println(minimumSwaps(arr));
    }
}
