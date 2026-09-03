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
    public void Invert(TreeNode root, TreeNode ans) {
        if (root == null)
            return;
        if (root.left != null) {
            TreeNode temp = new TreeNode(root.left.val);
            ans.right = temp;
            Invert(root.left, ans.right);
        }
        if (root.right != null) {
            TreeNode temp = new TreeNode(root.right.val);
            ans.left = temp;
            Invert(root.right, ans.left);
        }
    }

    public TreeNode invertTree(TreeNode root) {

        if (root == null)
            return root;
        TreeNode ans = new TreeNode(root.val);
        Invert(root, ans);
        return ans;
    }
}