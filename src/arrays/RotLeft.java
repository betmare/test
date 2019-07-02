package arrays;

import java.util.Arrays;

public class RotLeft {

    static int[] rotLeft(int[] a, int d) {
        int[] array = Arrays.copyOf(a,a.length);
        for(int i = 0; i<a.length;i++) {
            int newPos = i-d;
            if(newPos<0) {
                newPos=a.length - (-1)*(newPos);
            }
            a[newPos] = array[i];
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a={1,2,3,4,5};
        int d = 4;
        int[] rotedArray=rotLeft(a,d);
        for (int pos: rotedArray) {
            System.out.print(pos+" ");
        }
    }
}
