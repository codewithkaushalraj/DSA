class Solution {
    public int diameterOfBinaryTree(TreeNode root) {

        if(root==null) return 0;

        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);

        int a=leftHeight+rightHeight;
       int b=diameterOfBinaryTree(root.left);
       int c=diameterOfBinaryTree(root.right);

       return Math.max(a,Math.max(b,c));

    }

    public int heightOfTree(TreeNode root) {
        if (root == null)
            return 0;
            
        int leftSubTreeHeight = heightOfTree(root.left);
        int rightSubTreeHeight = heightOfTree(root.right);

        return 1 + Math.max(leftSubTreeHeight, rightSubTreeHeight);
    }
}