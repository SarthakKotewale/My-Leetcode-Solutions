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