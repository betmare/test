package jumpingonclouds;

public class JumpingOnClouds {

    static int jumpingOnClouds(int[] c) {
        int countJumps=0;
        int p = 0;
        while (p != c.length-1) {
            if(p+2<c.length && c[p+2]==0) {
                p=p+2;
                countJumps++;
            } else if(p+1<c.length&&c[p+1]==0) {
                p++;
                countJumps++;
            }else {
                if(p>0&&c[p-1]==0){
                    p=p-1;
                    countJumps--;
                }
            }

        }
        return countJumps;
    }

    public static void main(String[] args) {
        int [] c = {0, 0, 0, 0, 1, 0};
        System.out.println(jumpingOnClouds(c));
    }
}
