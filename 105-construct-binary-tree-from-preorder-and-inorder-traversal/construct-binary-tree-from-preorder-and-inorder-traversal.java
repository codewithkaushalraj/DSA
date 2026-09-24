class Solution {
    // --------------Method second ---------------
    // IMPORTANT

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return build(0, n - 1, 0, n - 1, preorder, inorder);
    }

    public TreeNode build(int inlo, int inhi, int prelo, int prehi, int[] preorder, int[] inorder) {
        if (inlo > inhi || prelo > prehi)
            return null;
        TreeNode root = new TreeNode(preorder[prelo]);
        int idx = -1;
        for (int i = inlo; i <= inhi; i++) {
            if (inorder[i] == preorder[prelo]) {
                idx = i;
                break;
            }
        }
        int leftSize = idx - inlo;

        TreeNode left = build(inlo, idx - 1, prelo + 1, prelo + leftSize, preorder, inorder);
        TreeNode right = build(idx + 1, inhi, prelo + leftSize + 1, prehi, preorder, inorder);

        root.left = left;
        root.right = right;
        return root;
    }
}