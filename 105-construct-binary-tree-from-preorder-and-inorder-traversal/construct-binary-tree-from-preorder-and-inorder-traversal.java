class Solution {
    public void TreeConstructor(TreeNode root, int[] preorder, int[] inorder) {

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int n = preorder.length;
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        int idx = -1;
        for (int i = 0; i < n; i++) {
            if (preorder[0] == inorder[i]) {
                idx = i;
                break;
            }
        }
        int[] lefthalfPreorder = Arrays.copyOfRange(preorder, 1, idx + 1);
        int[] righthalfPreorder = Arrays.copyOfRange(preorder, idx + 1, n);
        int[] lefthalfInorder = Arrays.copyOfRange(inorder, 0, idx);
        int[] righthalfInorder = Arrays.copyOfRange(inorder, idx + 1, n);

        TreeNode left = buildTree(lefthalfPreorder, lefthalfInorder);
        TreeNode right = buildTree(righthalfPreorder, righthalfInorder);

        root.left = left;
        root.right = right;

        return root;

    }
}