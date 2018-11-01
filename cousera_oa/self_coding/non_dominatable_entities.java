import java.lang.reflect.Array;
import java.util.*;
public class Non_dominatable_entities {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] arr = {{2,4}, {4,1}, {8,8}, {3,5}};
        int res = count(arr);
        System.out.println(res);
    }
    public static int count(int[][] arr) {
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] i1, int[] i2) {
                if (i1[0] == i2[0]) return i2[1] - i1[1];
                return i2[0] - i1[0];
            }
        });
        int count = 0;
        int max = arr[0][1];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i][1]) max = arr[i][1];
            else count++;
            
        }
        return count;
    }
    
}