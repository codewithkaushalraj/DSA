class Solution {
    static ArrayList<Integer> l;

    static void traversal(TreeNode root) {
        if (root == null)
            return;
        traversal(root.left);
        l.add(root.val);
        traversal(root.right);
    }

    public boolean isValidBST(TreeNode root) {
        l = new ArrayList<>();

        traversal(root);

        for (int i = 1; i < l.size(); i++) {
            if (l.get(i - 1) >= l.get(i))
                return false;
        }
        return true;

    }
}