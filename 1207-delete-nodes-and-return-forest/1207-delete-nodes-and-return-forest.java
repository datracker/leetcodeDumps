/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new ArrayList<>();
        Set<Integer> toDel = new HashSet<>();
        for (int del : to_delete) {
            toDel.add(del);
        }

        TreeNode newRoot = helper(root, toDel, res);
        if (newRoot != null && !toDel.contains(newRoot.val)) {
            res.add(newRoot);
        }

        return res;
    }

    TreeNode helper(TreeNode node, Set<Integer> toDel, List<TreeNode> res) {
        if (node == null) {
            return null;
        }

        TreeNode leftSubtree = helper(node.left, toDel, res);
        TreeNode rightSubtree = helper(node.right, toDel, res);

        if (toDel.contains(node.val)) {
            if (leftSubtree != null) res.add(leftSubtree);
            if (rightSubtree != null) res.add(rightSubtree);            
            return null;
        }

        node.left = leftSubtree;
        node.right = rightSubtree;

        return node;        
    }
}