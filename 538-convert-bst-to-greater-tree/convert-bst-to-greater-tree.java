class Solution {
    static int idx;

    void traversal(TreeNode root, ArrayList<Integer> l, boolean flag) {
        if (root == null)
            return;
        traversal(root.left, l, flag);

        if (!flag)
            l.add(root.val);
        else
            root.val = l.get(idx++);

        traversal(root.right, l, flag);
    }

    public TreeNode convertBST(TreeNode root) {
        idx = 0;

        ArrayList<Integer> l = new ArrayList<>();
        traversal(root, l, false);

        int n = l.size();

        for (int i = n - 2; i >= 0; i--) {
            l.set(i, (l.get(i) + l.get(i + 1)));
        }
        traversal(root, l, true);
        return root;

    }
}