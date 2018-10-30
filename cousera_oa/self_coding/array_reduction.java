public int reduce_sum(int[] nums) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(nums.length);
    for (int i = 0; i < nums.length; i++) {
        minHeap.add(nums[i]);
    }
    int score = 0;
    for (minHeap.size() > 1) {
        int first = minHeap.poll();
        int second = minHeap.poll();
        score += first + second;
        minHeap.add(first + second);
    }
    
    return score;
}