
// -------------------Method 3rd------------------
class Triplet {
    long max;
    long min;
    boolean isBST;

    Triplet(long max, long min, boolean isBST) {
        this.max = max;
        this.min = min;
        this.isBST = isBST;
    }
}

class Solution {
    Triplet minMax(TreeNode root) {
        if (root == null)
            return new Triplet(Long.MIN_VALUE, Long.MAX_VALUE, true);
        Triplet lst = minMax(root.left);
        Triplet rst = minMax(root.right);

        long max = Math.max(root.val, Math.max(lst.max, rst.max));
        long min = Math.min(root.val, Math.min(lst.min, rst.min));

        // for check bst its left,right subtree must be valid bst and leftsubtree ki max val should be less that root.val and right subtree maximum value should be greater than root.val

        boolean isBST = lst.isBST && rst.isBST && lst.max < root.val && rst.min > root.val;

        return new Triplet(max, min, isBST);

    }

    public boolean isValidBST(TreeNode root) {

        return minMax(root).isBST;
    }
}