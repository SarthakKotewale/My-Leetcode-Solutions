/* You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

Example 1:

Input: head = [1,2,3,4]
Output: [1,4,2,3]
Example 2:

Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3] */

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
    public void reorderList(ListNode head) {
        //code here
        if(head == null || head.next == null){
            return;
        }
        ListNode mid = middleNode(head);
        ListNode nhead = mid.next;
        mid.next = null;
        nhead = reverseOfLL(nhead);

        ListNode c1 = head;
        ListNode c2 = nhead;
        ListNode f1 = null;
        ListNode f2 = null;

        while(c2 != null){
            f1 = c1.next;
            f2 = c2.next;
            c1.next = c2;
            c2.next = f1;

            c1 = f1;
            c2 = f2;
        }
    }
    private ListNode middleNode(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){ //in this q, we need mid as real midnode - 1
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode reverseOfLL(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode forw = null;
        while(curr != null){
            forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        return prev;
    }
}