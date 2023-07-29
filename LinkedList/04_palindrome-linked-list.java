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
//METhOD 1
class Solution {
    public boolean isPalindrome(ListNode head) {
        pleft = head;
        return isPalindromeHelper(head);
    }
    ListNode pleft;
    private boolean isPalindromeHelper(ListNode right){
        if(right == null){
            return true;
        }
        boolean res = isPalindromeHelper(right.next);
        if(res == false) return false;
        else if(pleft.val != right.val) return false;
        else{
            pleft = pleft.next;
            return true;
        }
    }
}