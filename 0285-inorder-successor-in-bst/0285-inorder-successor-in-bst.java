/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<TreeNode> allNodes = new ArrayList<>();
    

    void inorderTraverse(TreeNode root) {
        if (root == null) return;
        inorderTraverse(root.left);
        allNodes.add(root);
        inorderTraverse(root.right);
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inorderTraverse(root);
        
        for (int i = 0; i < allNodes.size()-1; i++) {
            TreeNode node = allNodes.get(i);
            if (node.val == p.val) {
                return allNodes.get(i+1);
            }
        }

        return null;
    }
        
}
