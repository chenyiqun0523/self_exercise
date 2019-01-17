public class Solution {
    /** 593
     * @param p1: the first point
     * @param p2: the second point
     * @param p3: the third point
     * @param p4: the fourth point
     * @return: whether the four points could construct a square
     */
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        // Write your code here
        int p[][]={{p1[0],p1[1]},{p2[0],p2[1]},{p3[0],p3[1]},{p4[0],p4[1]}};
        int[] len = new int[6];
        int index = 0;
        for (int i = 0; i < 3; i++) {
           for (int j = i + 1; j < 4; j++) {
               len[index] = (p[i][0] - p[j][0])*(p[i][0] - p[j][0]) + (p[i][1] - p[j][1])*(p[i][1] - p[j][1]);
               index++;
           } 
        }
        Arrays.sort(len);
        if (len[0] == len[3] && len[4] == len[5] && len[0] < len[4]) {
            return true;
        } else {
            return false;
        }
    }
}


//找两个点，这两个点作为一个正方形的对角线，这样就可以算出另外一条对角线上的两个点，然后去set里找有没有这两个点。follow up不用写代码，说想法就可以了
public void find_validSquare(List<List<Integer>> list) {

    for (int i = 0; i < list.size() - 3; i++) {
        for (int j = i + 1; j < list.size() - 2; j++) {
            for (int k = j + 1; k < list.size() - 1; k++) {
                List<Integer> p4 = helper_isRightTriangle(list.get(i), list.get(j), list.get(k));
                if (p4 == null) {
                    continue;
                } else {
                    if (list.contains(p4)) {
                        ans.add()...
                    }
                }
            }
        }
    }
} 

public void find_validSquare(List<List<Integer>> list) {
    for (int i = 0; i < list.size() - 3; i++) {
        for (int j = i + 1; j < list.size() - 2; j++) {
            List<List<Integer>> rightTriangles = helper_findRightTriangle(list.get(i), list.get(j));

        }
    }
}