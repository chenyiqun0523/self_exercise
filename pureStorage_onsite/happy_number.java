//Leetcode 202
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> hash = new HashSet<>();
        while (n != 1) {
            if (hash.contains(n)) {
                return false;
            }
            hash.add(n);
            int temp = 0;
            while (n != 0) {
                //System.out.println((n % 10)*(n % 10));
                temp += (n % 10) * (n % 10);
                //System.out.println("temp " + temp);
                n = n / 10;
            }
            n = temp;
            //System.out.println("n: " + n);
        }
        return true;
    }
}