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
    public List<List<Integer>> helper(TreeNode root, List<List<Integer>> ans, List<Integer> l) {
        int currentLevel = 1;
        Queue<pair> q = new LinkedList<>();

        q.add(new pair(root, 0));
        while (q.size() > 0) {
            pair frontElem = q.remove();
            if (frontElem.level == currentLevel) {
                ans.add(new ArrayList<>(l)); // at this time It adds the previous level 
                currentLevel++;
                l.clear();
            }
            l.add(frontElem.node.val);

            if (frontElem.node.left != null)
                q.add(new pair(frontElem.node.left, frontElem.level + 1));

            if (frontElem.node.right != null)
                q.add(new pair(frontElem.node.right, frontElem.level + 1));
        }
        ans.add(new ArrayList<>(l)); // this will add the last level element
        return ans;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> l = new ArrayList<>();

        if (root == null)
            return ans;
        return helper(root, ans, l);
    }
}