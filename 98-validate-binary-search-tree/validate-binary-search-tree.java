// ------------Method second (IMPORTANT)---------------
class pair {
    long max;
    long min;

    pair(long max, long min) {
        this.max = max;
        this.min = min;
    }

}

class Solution {
    boolean flag; // true means give tree is a bst

    public pair minMax(TreeNode root) {
        if (root == null)
            return new pair(Long.MIN_VALUE, Long.MAX_VALUE);

        if (root.left == null && root.right == null)
            return new pair(root.val, root.val);

        pair lst = minMax(root.left);
        pair rst = minMax(root.right);

        if (lst.max >= root.val)
            flag = false;

        if (rst.min <= root.val)
            flag = false;

        long max = Math.max(root.val, Math.max(lst.max, rst.max));
        long min = Math.min(root.val, Math.min(lst.min, rst.min));

        return new pair(max, min);

    }

    public boolean isValidBST(TreeNode root) {

        flag = true;
        minMax(root);

        return flag;

    }
}