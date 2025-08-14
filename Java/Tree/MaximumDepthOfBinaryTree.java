package Tree;

import Tree.utils.TreeNode;

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max((root.left == null ? 0 : maxDepth(root.left)), (root.right == null ? 0 : maxDepth(root.right)));
    }
}