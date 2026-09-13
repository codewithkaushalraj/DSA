class pair {
    TreeNode root;
    int level;

    pair() {
    } // default constructor

    pair(TreeNode root, int level) { // parameterized Constructor
        this.root = root;
        this.level = level;
    }
}

class Solution {

    static List<Integer> ans;

    public List<Integer> rightSideView(TreeNode root) {

        ans = new ArrayList<>();

        if (root == null)
            return ans;

        Queue<pair> q = new LinkedList<>();

        q.add(new pair(root, 0));

        pair frontElem = new pair();

        while (q.size() > 0) {
            frontElem = q.remove();

            if (frontElem.root.left != null)
                q.add(new pair(frontElem.root.left, frontElem.level + 1));
            if (frontElem.root.right != null)
                q.add(new pair(frontElem.root.right, frontElem.level + 1));

            if (q.size() != 0) {
                if (q.peek().level != frontElem.level) {
                    ans.add(frontElem.root.val);
                }
            }
        }
        ans.add(frontElem.root.val);

        return ans;

    }
}