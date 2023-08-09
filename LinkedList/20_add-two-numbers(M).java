/* You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1] */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) return l1 != l2 ? l1 : l2;
        
        ListNode dummy = new ListNode(-1);
        ListNode itr = dummy;
        int carry = 0;
        ListNode c1 = l1;
        ListNode c2 = l2;
        
        while(c1 != null || c2 != null || carry != 0){
            int sum = carry + (c1 != null ? c1.val : 0) + (c2 != null ? c2.val : 0);
            int dig = sum % 10;
            carry = sum / 10;

            // ListNode node = new ListNode(dig);
            // itr.next = node;
            // itr = itr.next;
            itr.next = new ListNode(dig);
            itr = itr.next;

            if(c1 != null) c1 = c1.next;
            if(c2 != null) c2 = c2.next;
        }
        return dummy.next;
    }
    
}