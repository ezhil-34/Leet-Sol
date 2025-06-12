/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        HashSet<ListNode> h = new HashSet<>();
        while(headA!=null){
            h.add(headA);
            headA = headA.next;
        }
        while(headB!=null){
            if(h.contains(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }
}