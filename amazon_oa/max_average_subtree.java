public class TreeNode {
    public int val;
    public List<TreeNode> children;

    public TreeNode(int val) {
        this.val = val;
        this.children = new ArrayList<>();
    }
}

public class Solution {
    /*
     * @param root: the root of binary tree
     * 
     * @return: the root of the maximum average of subtree
     */
    class resultType {
        long sum;
        long count;

        public resultType(int sum, int count) {
            this.sum = sum;
            this.count = count;
        }
    }

    private TreeNode result = null;
    private resultType MaxRecord = new resultType(0, 0);

    public TreeNode findSubtree2(TreeNode root) {
        // write your code here
        DFS(root);
        return result;
    }

    private resultType DFS(TreeNode root) {
        if (root == null) {
            return new resultType(0, 0);
        }

        long sum = (long)root.val;
        long count = 1;
        for (TreeNode child : root.children) {
            resultType cur_child_result = DFS(child);
            sum += cur_child_result.sum;
            count += cur_child_result.count;
        }

        if (result == null || sum * MaxRecord.count > MaxRecord.sum * count) {
            MaxRecord.sum = sum;
            MaxRecord.count = count;
            result = root;
        }
        return new resultType(sum, count);
    }
}