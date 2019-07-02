package electronicshop;

import java.util.Arrays;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

public class ElectronicShop {
    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        int moneySpent = 0;
        SortedSet<Integer> sortedKeyboards = new TreeSet<>(Collections.reverseOrder());
        Collections.addAll(sortedKeyboards, Arrays.stream(keyboards).boxed().toArray(Integer[]::new));
        SortedSet<Integer> sortedDrives = new TreeSet<>(Collections.reverseOrder());
        Collections.addAll(sortedDrives, Arrays.stream(drives).boxed().toArray(Integer[]::new));
        for (Integer keyboard:sortedKeyboards) {
            for (Integer drive: sortedDrives) {
                int amount = keyboard + drive;
                if(amount<=b && amount>moneySpent) {
                    moneySpent = amount;
                }
            }
        }
        return moneySpent==0?-1:moneySpent;
    }

    public static void main(String[] args) {
        int[] keyboards = {5};
        int[] drives = {4};
        int budget = 5;
        System.out.println(getMoneySpent(keyboards,drives,budget));
    }
}
