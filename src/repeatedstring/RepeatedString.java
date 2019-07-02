package repeatedstring;

import java.util.Arrays;

public class RepeatedString {

    private static final char CHAR = 'a';



    static long repeatedString(String s, long n) {
        long numberRepeated = n/s.length();
        long rest = n%s.length();
        long numberCompleteChar = s.chars().filter(c-> c==CHAR).count();
        String subString = s.substring(0, (int) rest);
        long numberRestChar = subString.chars().filter(c -> c==CHAR).count();
        long timesOfChar = numberCompleteChar*numberRepeated + numberRestChar;
        return timesOfChar;
    }

    public static void main(String[] args) {
        String s = "a";
        long n = 1000000000;
        System.out.println(repeatedString(s,n));
    }
}
