/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node temp = head;
        while(temp!=null){
            Node clone = new Node(temp.val);
            clone.next = temp.next;
            temp.next = clone;
            temp = clone.next;
        }
         temp = head;
        while(temp !=null){
            if(temp.random!=null){
                temp.next.random = temp.random.next;
               
            }
             temp = temp.next.next;

        
        }
        Node dumm = new Node(0);
        Node curr = dumm;
        temp =head;
        while(temp!=null){

            curr.next = temp.next;
            curr = curr.next;

            temp.next = temp.next.next;
            temp = temp.next;
        }
        return dumm.next;

         
    }
}