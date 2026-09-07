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
class pair {
    TreeNode node;
    int level;

    pair(TreeNode node, int level) {
        this.level = level;
        this.node = node;
    }
}

class Solution {
    public List<List<Integer>> helper(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        Queue<pair> q = new LinkedList<>();
        int currentLevel = 1;
        if (root == null)
            return ans;

        q.add(new pair(root, 0));
        while (q.size() > 0) {
            pair frontElem = q.remove();
            if (frontElem.level == currentLevel) {
                ans.add(new ArrayList<>(l)); // at this time It adds the previous level 
                currentLevel++;
                l.clear();
            }
            l.add(frontElem.node.val);
            TreeNode leftChild = frontElem.node.left;
            TreeNode rightChild = frontElem.node.right;

            if (leftChild != null)
                q.add(new pair(leftChild, frontElem.level + 1));

            if (rightChild != null)
                q.add(new pair(rightChild, frontElem.level + 1));
        }
        ans.add(new ArrayList<>(l)); // this will add the last level element
        return ans;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        return helper(root);
    }
}