class Solution {
    public List<List<Integer>> football_score(int sum) {
        int[] types = {1, 3, 6};
        List<List<Integer>> result = new ArrayList<>();
        dfs(types, sum, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private void dfs(int[] types, int sum, int prev, List<Integer> subset, List<List<Integer>> result) {
        if (sum == 0) {
            result.add(new ArrayList<Integer>(subset));
            return;
        }

        if (prev == 6) {
            for (int i = 0; i < 3; i++) {
                if (sum - types[i] >= 0) {
                    subset.add(types[i]);
                    dfs(types, sum - types[i], types[i], subset, result);
                    subset.remove(subset.size() - 1);
                }
            }
        } else {
            if (sum - 6 >= 0) {
                subset.add(6);
                dfs(types, sum - 6, 6, subset, result);
            }
        }
        
    }

}