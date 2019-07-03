package arrays;


import java.util.Arrays;


public class ArrayManipulation {

    private static long arrayManipulation(int n, int[][] queries) {
        final long[] zeros = new long[n+1];
        Arrays.stream(queries).forEach(query -> {
            int a = query[0];
            int b = query[1];
            int k = query[2];
            zeros[a-1]+=k;
            if(b<=n){
                zeros[b]-=k;
            }
        });
        long max= 0;
        long x = 0;
        for(int i=0;i<=n;i++) {
            x = x+zeros[i];
            if(x>max) {
                max=x;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int n=10;
        int[][] queries = {{1,5,3},{4,8,7},{6,9,1}};
        System.out.println(arrayManipulation(n,queries));
    }
}
