public class ImageSmoother {
    public int[][] imageSmoother(int[][] matrix) {
        if (matrix.length == 0 || matrix == null) return null;
        if (matrix[0].length == 0 || matrix[0] == null) return null;

        // a b c d
        // e f g h
        // i j k l
        // m n o p

        //vertical operation:

        // 0+a+e 0+b+f 0+c+g 0+d+h
        // a+e+i b+f+j c+g+k d+h+l
        // e+i+m f+j+n g+k+o h+l+p
        // i+m+0 j+n+0 k+o+0 l+p+0

        int n = matrix.length;
        int m = matrix[0].length;
        //vertical
        int pre, cur;
        for (int j = 0; j < m; j++) {
            pre = 0;
            //cur = 0;
            for (int i = 0; i < n; i++) {
                cur = matrix[i][j];
                matrix[i][j] = pre + cur + (i + 1 < n ? matrix[i + 1][j] : 0);
                pre = cur;
            }
        }

        //horizontal
        for (int i = 0; i < n; i++) {
            pre = 0;
            //cur = 0;
            for (int j = 0; j < m; j++) {
                cur = matrix[i][j];
                matrix[i][j] = pre + cur + (j + 1 < m ? matrix[i][j + 1] : 0);
                //matrix[i][j] = matrix[i][j] / 9;
                pre = cur;
            }
        }

        //average
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ( (i == 0 && j ==0) || (i == 0 && j == m -1) || (i == n - 1 && j == 0) || (i == n - 1 && j == m - 1) ) {
                    matrix[i][j] = matrix[i][j] / 4;
                }else if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    matrix[i][j] = matrix[i][j] / 6;
                }else {
                    matrix[i][j] = matrix[i][j] / 9;
                }
            }
        }

        return matrix;
    }
}