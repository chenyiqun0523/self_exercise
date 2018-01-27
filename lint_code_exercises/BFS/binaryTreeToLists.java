public class Solution {
    public List<ListNode> binaryTreeToLists (TreeNode root) {
        ArrayList<ListNode> results = new ArrayList<ListNode>();
        if (root == null) {
            return results;    
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        ListNode dummy = new ListNode(0);
        ListNode pointer = null;
        while(!queue.isEmpty()) {
            dummy.next = null;
            pointer = dummy;
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode current_node = queue.poll();
                pointer.next = new ListNode(current_node.val);
                pointer = pointer.next;
                if (current_node.left != null) {
                    queue.offer(current_node.left);
                }
                if (current_node.right != null) {
                    queue.offer(current_node.right);
                }
            }
            results.add(dummy.next);
        } 
        return results;
    }
}
