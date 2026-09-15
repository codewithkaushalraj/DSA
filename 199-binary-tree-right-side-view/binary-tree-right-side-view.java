
//-------------- Method Second -----------

class Solution {
    public int levelOfTree(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(levelOfTree(root.left), levelOfTree(root.right));
    }

    public void preOrderTraversal(TreeNode root, int[] arr, int level) {
        if (root == null)
            return;

        arr[level] = root.val;
        preOrderTraversal(root.left, arr, level + 1);
        preOrderTraversal(root.right, arr, level + 1);
    }

    public List<Integer> rightSideView(TreeNode root) {

        int height = levelOfTree(root);
        int[] arr = new int[height];

        preOrderTraversal(root, arr, 0);

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            ans.add(arr[i]);
        }
        return ans;

    }
}