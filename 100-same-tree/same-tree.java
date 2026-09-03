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
    static boolean ans;

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // if ((p == null && q != null) || (p != null && q == null))
        //     return false;
        if (p == null && q == null)
            return true;
        else if(p==null ||q==null) return false;
        if (p.val != q.val)
            return false;
        ans = isSameTree(p.left, q.left);
        if (ans == false)
            return false;
        ans = isSameTree(p.right, q.right);
        if (ans == false)
            return false;
        else
            return true;

    }
}