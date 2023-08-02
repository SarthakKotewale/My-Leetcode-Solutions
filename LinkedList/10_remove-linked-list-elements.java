/*Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.

Example 1:


Input: head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5]
Example 2:

Input: head = [], val = 1
Output: []
Example 3:

Input: head = [7,7,7,7], val = 7
Output: [] */

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        
        ListNode curr = head;
        
        while(curr != null){
            ListNode forw = curr.next;
            
            if(curr.val == val){
                prev.next = forw;
                curr.next = null;
                curr = forw;
            }else{
                prev = curr;
                curr = forw;
            }
        }
        return dummy.next;
    }
}