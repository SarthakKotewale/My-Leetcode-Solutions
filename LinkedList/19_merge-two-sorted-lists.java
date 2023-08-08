/* You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

Example 1:

Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0] */

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null || list2 == null){
            return list1 != null ? list1 : list2;
        }
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode h1 = list1;
        ListNode h2 = list2;

        while(h1 != null && h2 != null){
            if(h1.val <= h2.val){
                prev.next = h1;
                h1 = h1.next;
            }else{
                prev.next = h2;
                h2 = h2.next;
            }
            prev = prev.next;
        }
        // prev.next = c1 != null ? c1 : c2;
        if(h1 != null){
            prev.next = h1;
        }else{
            prev.next = h2;
        }

        return dummy.next;
    }
}