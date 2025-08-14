package Tree;

import Tree.utils.TreeNode;

class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        TreeNode left = root.left;
        if (left != null) {
            while (left.right != null) {
                left = left.right;
            }
        }
        
        TreeNode right = root.right;
        if (right != null) {
            while (right.left != null) {
                right = right.left;
            }
        }

        boolean leftOk = left == null ? true : left.val < root.val;
        boolean rightOk = right == null ? true : right.val > root.val;
        return isValidBST(root.left) && isValidBST(root.right) && leftOk && rightOk;
    }
}