// 25. Reverse Nodes in k-Group
// Hard
// Topics
// Companies
// Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

// k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

// You may not alter the values in the list's nodes, only nodes themselves may be changed.

 

// Example 1:


// Input: head = [1,2,3,4,5], k = 2
// Output: [2,1,4,3,5]
// Example 2:


// Input: head = [1,2,3,4,5], k = 3
// Output: [3,2,1,4,5]

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;
        
        while (true) {
            ListNode kth = getKthNode(prevGroupEnd, k);
            if (kth == null) break; // 남은 노드가 k개 미만이면 종료
            
            ListNode nextGroupStart = kth.next;
            // 노드 뒤집기
            ListNode prev = kth.next;
            ListNode current = prevGroupEnd.next;
            
            while (current != nextGroupStart) {
                ListNode next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            
            ListNode newGroupEnd = prevGroupEnd.next;
            prevGroupEnd.next = kth;
            prevGroupEnd = newGroupEnd;
        }
        
        return dummy.next;
    }
    
    private ListNode getKthNode(ListNode node, int k) {
        while (node != null && k > 0) {
            node = node.next;
            k--;
        }
        return node;
    }
}
