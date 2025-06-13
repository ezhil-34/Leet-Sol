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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0){
            return head;
        }
       int len = 1;
       ListNode curr = head;
       while(curr.next!=null){
        curr = curr.next;
        len++;
       }
       curr.next = head;
        k = k%len;
        int step = len -k;
        ListNode ste = head;
        for(int i =1 ;i<step ;i++){
            ste = ste.next;
        }
         ListNode newh = ste.next;
        ste.next = null;
      return newh;

       


    }
}