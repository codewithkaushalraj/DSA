class Solution {
    // -----------------------(Method - 3- Solved by morries traversal with o(1) extra space )-------------------------------
    public void flatten(TreeNode root) {

        TreeNode curr = root;

        while (curr != null) {
            if (curr.left != null) {
                // find predeicassor
                TreeNode pred = curr.left;
                while (pred.right != null)
                    pred = pred.right;
                pred.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }

    }
}