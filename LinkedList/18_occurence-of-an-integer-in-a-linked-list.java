/*Given a singly linked list and a key, count the number of occurrences of given key in the linked list.

Example 1:

Input:
N = 7
Link List = 1->2->1->2->1->3->1
search_for = 1
Output: 4
Explanation:1 appears 4 times.
Example 2:

Input:
N = 5
Link List = 1->2->1->2->1
search_for = 3
Output: 0
Explanation:3 appears 0 times. */


class Solution {
    public static int count(Node head, int search_for){
        int cnt = 0;
        Node curr = head;
        while(curr != null){
            if(curr.data == search_for){
                cnt++;
            }
            curr = curr.next;
        }
        return cnt;
    }
}


//Approach :

// Initialize a counter cnt to keep track of the number of occurrences of the given key.

// Start traversing the linked list from the head node by initializing a curr pointer to the head.

// Enter a loop that iterates through the linked list until the curr pointer becomes null, which means we have reached the end of the list.

// Inside the loop, check if the data value of the current node (curr.data) matches the search_for value. If it does, increment the cnt counter, indicating that we've found an occurrence of the key.

// Move the curr pointer to the next node in the list by updating curr = curr.next.

// Repeat steps 4 and 5 for each node in the linked list until we reach the end of the list.

// Once the loop is finished, return the final value of the cnt counter, which represents the total number of occurrences of the given key in the linked list.

// In summary, the approach involves traversing the entire linked list while checking each node's data value. If the data value matches the given key, we increment the counter. This way, we count the number of occurrences of the specified key in the linked list.