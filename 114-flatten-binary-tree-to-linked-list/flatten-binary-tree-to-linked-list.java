class Solution {
    public void flatten(TreeNode root) {

        if (root == null)
            return;
        TreeNode left = root.left;
        TreeNode right = root.right;

        if (left != null) {
            root.left = null;
            root.right = left;
            flatten(root.right);

            // Find the last node of flattened left subtree
            TreeNode temp = root.right;
            while (temp.right != null) {
                temp = temp.right;
            }

            // Attach original right subtree
            temp.right = right;

        }
            flatten(root.right); // this will run one more time bevause those node you attach on last statement of if you should also check for right shubTree as well

    }
}