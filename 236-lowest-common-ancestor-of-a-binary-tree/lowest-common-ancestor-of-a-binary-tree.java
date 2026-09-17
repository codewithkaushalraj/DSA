class Solution {

// This code will give TLE ERROR

    // public static int ans;

    // public boolean isExist(TreeNode root, TreeNode p) {
    //     if (root == null)
    //         return false;
    //     if (root.val == p.val)
    //         return true;
    //     return isExist(root.left, p) || isExist(root.right, p);

    // }

    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

    //     if (root.val == p.val)
    //         return root;

    //     boolean pLocationinLeft = isExist(root.left, p);
    //     boolean qLocationinLeft = isExist(root.left, q);

    //     boolean leftSubTree = pLocationinLeft && qLocationinLeft;
    //     if (leftSubTree == true)
    //         return lowestCommonAncestor(root.left, p, q);

    //     boolean pLocationinRight = isExist(root.right, p);
    //     boolean qLocationinRight = isExist(root.right, q);

    //     boolean rightSubTree = pLocationinRight && qLocationinRight;
    //     if (rightSubTree == true)
    //         return lowestCommonAncestor(root.right, p, q);

    //     return root;
    // }

    //--------------------------


     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if root is null or matches p or q, return root
        if (root == null || root == p || root == q) {
            return root;
        }
        
        // Look for p and q in left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // If both left and right return non-null, current root is the LCA
        if (left != null && right != null) {
            return root;
        }
        
        // Otherwise return the non-null child result
        return left != null ? left : right;
    }
}