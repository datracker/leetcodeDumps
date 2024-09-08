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
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        int size = getSize(head);
        int rem = size % k;
        int pieceSize = size / k;

        ListNode curr = head;
        ListNode prev = null;
        for (int i = 0; i < k; i++) {
            res[i] = curr;
            int offset = rem > 0 ? 1 : 0;
            for (int j = 0; j < (pieceSize + offset) && curr != null; j++) {
                prev = curr;
                curr = curr.next;
            }
            if (prev != null) prev.next = null;
            prev = null;
            rem--;
        }
        

        return res;
    }

    int getSize(ListNode head) {
        int size = 0;
        ListNode curr = head;
        while (curr != null) {
            size++;
            curr = curr.next;
        }

        return size;
    }
}