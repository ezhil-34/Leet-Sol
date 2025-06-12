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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next==null){
            return head;
        }
        ListNode mid = fndmid(head);
        ListNode right = mid.next;
        mid.next = null;
        ListNode left = head;
        left = sortList(left);
        right = sortList(right);
        return merge(left,right);

        
    }
    public static ListNode fndmid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast!= null && fast.next!= null){
            prev =slow;
            slow = slow.next;
            fast = fast.next.next;

        }
        return prev;
    }
    public static ListNode merge(ListNode l1,ListNode l2){
        ListNode dumm = new ListNode(-1);
        ListNode temp = dumm;
        while(l1!=null && l2!= null){
            if(l1.val<l2.val){
                temp.next = l1;
                l1 = l1.next;

            }
            else{
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }

        if(l1!=null){
            temp.next = l1;
            l1 = l1.next;
        }
         if(l2!=null){
            temp.next = l2;
            l2 = l2.next;
        }
        return dumm.next;

    }
}