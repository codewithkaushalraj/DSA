/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public static List<Integer> ans;

    public void Traversal(TreeNode root, List<Integer> ans) {
        if (root == null)
            return;
        Traversal(root.left, ans);
        ans.add(root.val);
        Traversal(root.right, ans);

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        ans = new ArrayList<>();
        Traversal(root, ans);

        return ans;
    }
}