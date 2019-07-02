package gcd;

import java.util.Arrays;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class GCD {

    public static int generalizedGCD(int num, int[] arr)
    {
        int gcd = 0;
        SortedSet<Integer> sortedNumbers = new TreeSet<>();
        Collections.addAll(sortedNumbers, Arrays.stream(arr).boxed().toArray(Integer[]::new));
        for(int i = sortedNumbers.last(); i>0; i--) {
            boolean isDivisor = true;
            for (Integer number:sortedNumbers) {
                if(number%i!=0) {
                    isDivisor=false;
                    break;
                }
            }
            if(isDivisor) {
                gcd=i;
                break;
            }
        }
        return gcd;
    }
    public static void main(String[] args) {
        int[] arr = {2,3,4,5,6};
        int num = 5;
        System.out.println(generalizedGCD(num,arr));
    }
}
