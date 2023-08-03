/* Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

Example 1:

Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
Example 2:

Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5] */


//SC - O(n)
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        int size = size(head);
        ListNode curr = head;
        ListNode oh = null; //orig head
        ListNode ot = null; //orig tail
        while(size >= k){
            int tempK = k;
            while(tempK-- > 0){
                ListNode forw = curr.next;
                curr.next = null;
                addFirst(curr);
                curr = forw;
            }
            if(oh == null){
                oh = th;
                ot = tt;
            }else{
                ot.next = th;
                ot = tt;
            }

            th = null;
            tt = null;
            size -= k;
        }

        ot.next = curr;
        return oh;
    }
    public int size(ListNode head){
        ListNode curr = head;
        int len = 0;
        while(curr != null){
            curr = curr.next;
            len++;
        }
        return len;
    }

    static ListNode th = null;
    static ListNode tt = null;
    public void addFirst(ListNode head){
        if(th == null){
            th = head;
            tt = head;
        }else{
            head.next = th;
            th = head; 
        }
    }
}