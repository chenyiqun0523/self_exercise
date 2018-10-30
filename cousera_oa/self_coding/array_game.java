public int countMoves(int[] nums) {
    int sumNum = 0;
    int minNum = Integer.MAX_VALUE;
    for (int num : nums) {
        sumNum += num;
        minNum = Math.min(minNum, num);
    }
    return sumNum - minNum * nums.length;
}