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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[] {-1, -1};
        }

        ListNode prev = head;
        ListNode curr = head.next;
        ListNode nex = head.next.next;

        int currPosn = 1;
        int first = -1;
        int last = -1;

        int[] res = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};

        while (nex != null) {
            if ((curr.val > prev.val && curr.val > nex.val) || 
                (curr.val < prev.val && curr.val < nex.val)) {

                if (first == -1) {
                    first = currPosn;
                }
                if (last != -1) {
                    res[1] = currPosn - first;
                    res[0] = Math.min(currPosn - last, res[0]);
                }
                last = currPosn;
            }
            prev = curr;
            curr = nex;
            nex = nex.next;
            currPosn++;
        }

        if (res[0] == Integer.MAX_VALUE || res[1] == Integer.MIN_VALUE) {
            return new int[] {-1, -1};
        }

        return res;
    }
}