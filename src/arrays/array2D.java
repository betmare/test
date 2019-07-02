package arrays;

public class array2D {
    static int hourglassSum(int[][] arr) {
        int countMax=Integer.MIN_VALUE;
        for(int i = 0; i<arr.length-2;i++) {
            for(int j = 0; j<arr[i].length-2;j++) {
                int count;
                int row1 = arr[i][j]+arr[i][j+1]+arr[i][j+2];
                int row2 = arr[i+1][j+1];
                int row3 = arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
                count = row1+row2+row3;
                if(count>countMax) {
                    countMax=count;
                }
            }
        }
        return countMax;
    }
    public static void main(String[] args) {
        int[][] array = {{1,1,1,0,0,0},
                         {0,1,0,0,0,0},
                         {1,1,1,0,0,0},
                         {0,0,2,4,4,0},
                         {0,0,0,2,0,0},
                         {0,0,1,2,4,0}};
        System.out.println(hourglassSum(array));
    }
}
