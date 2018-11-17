public class Solution {
    /*
     * @param nums: A list of integers
     * @param k: An integer
     * @return: The maximum number inside the window at each moving
     */
    //从尾部开始，去除所有小于num的数
    private void inQueue(Deque<Integer> deque, int num) {
        while (!deque.isEmpty() && deque.peekLast() < num) {
            deque.pollLast();
        }
        deque.offer(num);
    } 
    
    private void outQueue(Deque<Integer> deque, int num) {
        if (deque.peekFirst() == num) {
            deque.pollFirst();
        }
    }
    
    
    
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here

        ArrayList<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Deque<Integer> deque = new ArrayDeque<Integer>();
        for (int i = 0; i < k - 1; i++) {
            inQueue(deque, nums[i]);
        }
        
        for (int i = k - 1; i < nums.length; i++) {
            inQueue(deque, nums[i]);
            result.add(deque.peekFirst());
            outQueue(deque,nums[i - k + 1]);
        }
        
        return result;
    }
};