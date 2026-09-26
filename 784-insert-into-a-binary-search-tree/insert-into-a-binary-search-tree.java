class Solution {
    public void helper(TreeNode root, int val) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            TreeNode t = new TreeNode(val);

            if (root.val < val)
                root.right = t;
            else
                root.left = t;
            return;
        }

        if (root.val < val) {
            if (root.right != null)
                helper(root.right, val);

            else {
                TreeNode t = new TreeNode(val);
                if (root.val < val)
                    root.right = t;
                else
                    root.left = t;
                return;
            }

        } else {
            if (root.left != null)
                helper(root.left, val);
            else {
                TreeNode t = new TreeNode(val);
                if (root.val < val)
                    root.right = t;
                else
                    root.left = t;
                return;
            }
        }
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) {
            TreeNode t = new TreeNode(val);
            return t;
        }

        TreeNode temp = root;

        helper(root, val);

        return temp;
    }
}