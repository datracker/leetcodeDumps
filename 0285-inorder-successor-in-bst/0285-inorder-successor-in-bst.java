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
    TreeNode ans = null;
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode node = root;
        while (node != null) {
            if (node.val <= p.val) {
                node = node.right;
            }
            else {
                ans = node;
                node = node.left;
            }
        }

        return ans;
    }
}