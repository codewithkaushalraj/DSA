class Solution {
    public void inorder(TreeNode root, List<Integer> l) {
        if (root == null)
            return;
        inorder(root.left, l);
        l.add(root.val);
        inorder(root.right, l);
    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> l = new ArrayList<>();

        inorder(root, l);

        return l.get(k - 1);
    }
}