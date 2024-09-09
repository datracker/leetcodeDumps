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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        int rowStart = 0, rowEnd = m-1;
        int colStart = 0, colEnd = n-1;

        int count = 0;
        ListNode curr = head;
        while (count < m*n) {
            //first row
            for (int j = colStart; j <= colEnd; j++) {            
                if (curr == null) {
                    res[rowStart][j] = -1;
                }
                else {
                    res[rowStart][j] = curr.val;
                    curr = curr.next;
                }
                count++;                
            }
            rowStart++;

            //last col
            for (int i = rowStart; i <= rowEnd; i++) {
                if (curr == null) {
                    res[i][colEnd] = -1;
                }
                else {
                    res[i][colEnd] = curr.val;
                    curr = curr.next;
                }
                count++;
            }
            colEnd--;

            if (count < m*n) {
                //last row
                for(int j = colEnd; j >= colStart; j--) {
                    if (curr == null) {
                        res[rowEnd][j] = -1;
                    }
                    else {
                        res[rowEnd][j] = curr.val;
                        curr = curr.next;
                    }
                    count++;
                }
                rowEnd--;

                //first col
                for (int i = rowEnd; i >= rowStart; i--) {
                    if (curr == null) {
                        res[i][colStart] = -1;
                    }
                    else {
                        res[i][colStart] = curr.val;
                        curr = curr.next;
                    }
                    count++;
                }
                colStart++;
            }
        }
        
        return res;        
    }
}