class Solution {
    TreeNode build(int[] arr, int low, int high) {
        if (low > high)
            return null;
        int mid = (low + high) / 2;

        TreeNode root = new TreeNode(arr[mid]);
        TreeNode left = build(arr, low, mid - 1);
        TreeNode right = build(arr, mid + 1, high);
        
        root.left = left;
        root.right = right;
        return root;

    }

    public TreeNode sortedArrayToBST(int[] arr) {

        int n = arr.length;

        return build(arr, 0, n - 1);

    }
}