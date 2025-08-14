package Tree;

import Tree.utils.TreeNode;

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int left = count(root.left);
        if (left + 1 > k) {
            return kthSmallest(root.left, k);
        } else if (left + 1 < k) {
            return kthSmallest(root.right, k - left - 1);
        } else {
            return root.val;
        }
    }

    private int count(TreeNode root) {
        if (root == null) return 0;
        return 1 + count(root.left) + count(root.right);
    }
}