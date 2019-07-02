package oodnumbers;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Solution {


    static List<Integer> oddNumbers(int l, int r) {
        List<Integer> integers = new ArrayList<>();
        for(int i=l; i<r+1;i++) {
            if(i%2!=0) {
                integers.add(i);
            }
        }
        return integers;
    }

    public static void main(String[] args) throws IOException {
        List<Integer> toPrint =oddNumbers(2,9);
        for (Integer i: toPrint) {
            System.out.println(i);
        }
    }
}
