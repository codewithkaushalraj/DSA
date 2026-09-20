class Solution {

    // Method second - Iterative Approach

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        if (root == null)
            return ans;

        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        while (s.size() > 0) {
            TreeNode topElem = s.pop();
            ans.add(topElem.val);
            if (topElem.right != null)
                s.push(topElem.right);
            if (topElem.left != null)
                s.push(topElem.left);
        }
        return ans;

    }
}