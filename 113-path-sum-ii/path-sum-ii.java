class Solution {
    public void helper(TreeNode root, List<Integer> l, List<List<Integer>> ans, int targetSum, int sum) {
        if (root == null)
            return;

        if ((root.left == null && root.right == null) && (sum + root.val == targetSum)) {
            l.add(root.val);
            ans.add(new ArrayList<>(l));
            l.remove(l.size() - 1);
            return;
        }

        l.add(root.val);
        sum += root.val;

        helper(root.left, l, ans, targetSum, sum);
        helper(root.right, l, ans, targetSum, sum);

        l.remove(l.size() - 1);

    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> l = new ArrayList<>();

        if (root == null)
            return ans;

        helper(root, l, ans, targetSum, 0);

        return ans;

    }
}