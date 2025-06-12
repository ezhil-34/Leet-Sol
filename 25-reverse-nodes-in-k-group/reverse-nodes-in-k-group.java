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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode temp = head;
        ListNode prevL = null;
        while(temp!=null){
            ListNode kth = kthn(temp,k);
            if(kth == null){
                if(prevL!=null){
                    prevL.next = temp;
                    break;
                }
            }
            ListNode next = kth.next;
            kth.next = null;

            rev(temp);

            if(temp == head){
                head = kth;
            }
            else{
                prevL.next = kth;
            }
            prevL = temp;
            temp = next;


        }
        return head;

    }
    public static ListNode kthn(ListNode temp,int k){
        k-=1;
        while(temp!=null&&k>0){
            temp = temp.next;
            k--;
        }
        return temp;
    }
    public static ListNode rev(ListNode head){

        ListNode temp = head;

        ListNode prev = null;
        while(temp!=null){
            ListNode front = temp.next;
            temp.next = prev;
            prev= temp;
            temp = front;
        }
        return temp;

    }
}