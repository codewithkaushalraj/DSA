class Solution {
    static int sum;

    public void traversal(TreeNode root, int low, int high) {

        if (root == null)
            return;
        if (root.val >= low && root.val <= high) {
            sum += root.val;
            traversal(root.left, low, high);
            traversal(root.right, low, high);
        }

        else if (root.val < low)
            traversal(root.right, low, high);
        else if (root.val > high)
            traversal(root.left, low, high);
    }

    public int rangeSumBST(TreeNode root, int low, int high) {

        sum = 0;

        traversal(root, low, high);
        return sum;

    }
}