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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curr = head;
        ListNode nex = curr.next;
        while (curr != null && nex != null) {
            ListNode newNode = new ListNode(getGcd(curr.val, nex.val));
            curr.next = newNode;
            newNode.next = nex;
            curr = nex;
            nex = nex.next;
        }
        return head;
    }

    public int getGcd(int a, int b){
        if(a == 1 || b==1){
            return 1;
        }
        while(b !=0){
            int rem = a % b;
            a = b;
            b= rem;
        }
        return a;
    }
    
    // int getGcd(int a, int b) {
    //     if (a == b) return a;
    //     if (b > a) {
    //         int temp = b;
    //         b = a;
    //         a = temp;
    //     }

    //     int divider = 1;
    //     int div = b / divider;
    //     while (div > 1) {
    //         if (a % div == 0 && b % div == 0) return div;
    //         divider++;
    //         div = b / divider;
    //     }
    //     return 1;
    // }
}