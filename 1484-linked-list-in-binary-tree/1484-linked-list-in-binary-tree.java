/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    // public boolean isSubPath(ListNode head, TreeNode root) {
    //     if (head == null) {
    //         return true;
    //     }
    //     if (head != null && root == null) {
    //         return false;
    //     }

    //     if (head.val == root.val) {
    //         boolean res = isSubPath(head.next, root.left) || isSubPath(head.next, root.right);
    //         if (res) {
    //             return res;
    //         }
    //     }
    //     return isSubPath(head, root.left) || isSubPath(head, root.right);
    // }

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }
        // Check if the path starts at the current root node
        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean dfs(ListNode head, TreeNode root) {
        if (head == null) {
            return true; // End of the linked list means a subpath is found
        }
        if (root == null || head.val != root.val) {
            return false; // Either reached the end of the tree or values don't match
        }
        // Continue exploring both subtrees
        return dfs(head.next, root.left) || dfs(head.next, root.right);
}
}