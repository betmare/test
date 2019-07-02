package countingvaleys;

public class Solution {

    static int countingValleys(int n, String s) {
        int countValleys = 0;
        int level = 0;
        for (int i = 0; i < s.length(); i++) {
            char step = s.charAt(i);
            if(level == -1 && step == 'U') {
                countValleys++;
            }
            if(step=='U'){
                level++;
            }else if(step=='D') {
                level--;
            }
        }
        return countValleys;
    }

    public static void main(String[] args) {
        int steps=100;
        String path = "DDUDUDDUDDUDDUUUUDUDDDUUDDUUDDDUUDDUUUUUUDUDDDDUDDUUDUUDUDUUUDUUUUUDDUDDDDUDDUDDDDUUUUDUUDUUDUUDUDDD";
        System.out.println(countingValleys(steps,path));
    }
}
