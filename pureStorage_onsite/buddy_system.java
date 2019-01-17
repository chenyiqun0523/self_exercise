//https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=226030&extra=page%3D127%26filter%3Dsortid%26sortid%3D311%26sortid%3D311
class buddy_system {
    public static void clearBit(int[][] bits,  int offset, int length) {
        int curLevel = bits.length-1;
        int left = offset;
        int right = offset+length - 1;
        while (curLevel >= 0){
            for (int i = left; i <= right; i++) {
                bits[curLevel][i] = 0;
            }
            curLevel--;
            left = left/2;
            right = right/2;
        }
    }
    public static void setBit(int[][] bits,  int offset, int length) {
        int curLevel = bits.length-1;
        int left = offset;
        int right = offset+length - 1;
        while (curLevel >= 0) {
            for (int i = left; i <= right; i++) {
                bits[curLevel][i] = 1;             
            }
            int leftBuddy = left + (left % 2 == 1 ? -1 : 1);
            int rightBuddy = right + (right % 2 == 1 ? -1 : 1);
            int leftBit = bits[curLevel][left] * bits[curLevel][leftBuddy];
            int rightBit = bits[curLevel][right] * bits[curLevel][rightBuddy];
            curLevel--;
            left /= 2;
            right /= 2;
            if (leftBit == 0) {
                left++;
            }
            if (rightBit == 0) {
                right--; 
            }
        }
    }
}
