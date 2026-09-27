
class Solution {

    public int leftSubTreeCount(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + leftSubTreeCount(root.left) + leftSubTreeCount(root.right);
    }

    public int kthSmallest(TreeNode root, int k) {

        int leftElem = 0;
        if (root.left != null)
            leftElem = leftSubTreeCount(root.left);

        if (leftElem >= k)
            return kthSmallest(root.left, k);

        else if (leftElem + 1 == k)
            return root.val;

        else
            return kthSmallest(root.right, k - leftElem - 1);

    }
}