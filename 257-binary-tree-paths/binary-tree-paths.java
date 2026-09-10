class Solution {
    public void helper(TreeNode root, StringBuilder path, List<String> ans) {
        if (root.left == null && root.right == null) {
            int len = path.length();
            path.append(root.val);

            ans.add(path.toString()); // convert StringBuilder into string

            int length = path.length();
            path.setLength(len);
            return;
        }

        int length = path.length();
        path.append(root.val + "->");

        if (root.left != null)
            helper(root.left, path, ans);
            
        if (root.right != null)
            helper(root.right, path, ans);

        path.setLength(length);
        // path.delete(path.length() - 3, path.length()); //once parent node is visited then you should remove the parent element so this line will  reomve "parentElem->"
    }

    public List<String> binaryTreePaths(TreeNode root) {

        StringBuilder path = new StringBuilder();
        List<String> ans = new ArrayList<>();

       helper(root, path, ans);

       return ans;

    }
}