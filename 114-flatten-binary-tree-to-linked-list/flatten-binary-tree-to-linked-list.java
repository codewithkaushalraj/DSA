class Solution {
    public void flatten(TreeNode root) {

        // Method 2nd

        if (root == null)
            return;

        TreeNode lst = root.left;
        TreeNode rst = root.right;

        root.left = null;
        root.right = null;

        flatten(lst);
        flatten(rst);

        root.right = lst;
        TreeNode temp = root;
        while (temp.right != null)
            temp = temp.right;

        temp.right = rst;

    }
}