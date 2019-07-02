package pairsocks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Solution {

    static int sockMerchant(int n, int[] ar) {
        int count = IntStream.of(ar).
                boxed().
                collect(Collectors.groupingBy(c -> c, Collectors.counting())).
                entrySet().stream().filter(i -> i.getValue() > 1).
                mapToInt(p-> (int) (p.getValue()/2)).sum();
        return  count;
    }

    public static void main(String[] args) throws IOException {
        int numberSocks = 9;
        int[] ar = {10, 20, 20, 10, 10, 30, 50, 10, 20};
        System.out.println(sockMerchant(numberSocks, ar));
    }
}
