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
    public ListNode reverseList(ListNode head) {
        //Recursive
        return rlf(head, null);
    }
    private ListNode rlf(ListNode head, ListNode nhead){
        if(head == null){
            return nhead; 
        }
        ListNode nxt = head.next;
        head.next = nhead;
        return rlf(nxt, head);
    }
}
// Method 2 (pep intuitive)(gfg)
class Solution 
{
    //Function to reverse a linked list.
    Node reverseList(Node head)
    {
        // code here
        Node res = reverseListHelper(head);
        return res;
    }
    Node reverseListHelper(Node head){
        if(head == null || head.next == null) return head;
        
        Node h = reverseListHelper(head.next);
        head.next.next = head;
        head.next = null;
        return h;
    }
}