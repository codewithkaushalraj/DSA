class Quad {
    int max;
    int min;
    int maxSum;
    boolean isBST;

    Quad(int max, int min, boolean isBST, int maxSum) {
        this.max = max;
        this.min = min;
        this.isBST = isBST;
        this.maxSum = maxSum;
    }
}

class Solution {
    static int maximumSum;

    Quad helper(TreeNode root) {
        if (root == null)
            return new Quad(Integer.MIN_VALUE, Integer.MAX_VALUE, true, 0);
        Quad lst = helper(root.left);
        Quad rst = helper(root.right);

        int max = Math.max(root.val, Math.max(lst.max, rst.max));
        int min = Math.min(root.val, Math.min(lst.min, rst.min));

        int sum = root.val + lst.maxSum + rst.maxSum;
        boolean isBST = lst.isBST && rst.isBST && lst.max <= root.val && rst.min > root.val;
        if (isBST)
            maximumSum = Math.max(maximumSum, sum);
        return new Quad(max, min, isBST, sum);
    }

    public int maxSumBST(TreeNode root) {

        maximumSum = 0;

        helper(root);

        return maximumSum;

    }
}