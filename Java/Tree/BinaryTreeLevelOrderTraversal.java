package Tree;

import Tree.utils.TreeNode;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        List<Integer> rootList = new ArrayList<>();
        rootList.add(root.val);
        res.add(rootList);

        List<List<Integer>> left = levelOrder(root.left);
        List<List<Integer>> right = levelOrder(root.right);
        int i = 0;
        while (i < left.size() || i < right.size()) {
            List<Integer> nextList = new ArrayList<>();
            if (i < left.size()) {
                nextList.addAll(left.get(i));
            }
            if (i < right.size()) {
                nextList.addAll(right.get(i));
            }
            res.add(nextList);
            i++;
        }
        return res;
    }
}

//===========================================================================================================

class DFSSolution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        depthFirstSearch(root, 0, result);
        return result;
    }
    
    public void depthFirstSearch(TreeNode node, int level, List<List<Integer>> result){
        if(node == null) return;
        
        if(result.size() < (level+1)){
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        
        depthFirstSearch(node.left, level + 1, result);
        depthFirstSearch(node.right, level + 1, result);        
    }
}