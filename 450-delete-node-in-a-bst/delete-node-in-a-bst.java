class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (root.val < key) {// go right
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {// go left
            root.left = deleteNode(root.left, key);
        } else { // mil gya
                 //case 1 (0 children)
            if (root.left == null && root.right == null) { // means leaf node
                return null;
            }
            //case 2 (1 children)
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;

            // //case 3 (2 children)
            TreeNode pred = root.left; // pred stands for predecessor
            while (pred.right != null)
                pred = pred.right;
            root.left = deleteNode(root.left, pred.val); // IMPORTANT LINE
            pred.left = root.left;
            pred.right = root.right;
            return pred;
        }

        return root;
    }
}