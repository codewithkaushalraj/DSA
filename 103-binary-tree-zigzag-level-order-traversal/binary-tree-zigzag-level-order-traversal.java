class pair {
    TreeNode node;
    int level;

    pair(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> l = new LinkedList<>();

        if (root == null)
            return ans;

        Queue<pair> q = new LinkedList<>();
        q.add(new pair(root, 0));

        int currentLevel = 1;

        while (q.size() > 0) {
            pair frontElem = q.remove();
            TreeNode leftChild = frontElem.node.left;
            TreeNode rightChild = frontElem.node.right;
            int level = frontElem.level;

            if (level == currentLevel) {
                if (level % 2 == 0) {
                    Collections.reverse(l);
                }
                ans.add(new LinkedList<>(l)); // remember that at each time when we add element then on that time you add the element of previous level so that's by you take a modulo 2 ==0 
                currentLevel++;
                l.clear();
            }
            l.add(frontElem.node.val); // added the last level element 
            if (leftChild != null)
                q.add(new pair(leftChild, level + 1));
            if (rightChild != null)
                q.add(new pair(rightChild, level + 1));

        }
        if (currentLevel % 2 == 0) {
            Collections.reverse(l);
        }
        ans.add(new LinkedList<>(l));

        return ans;

    }
}