// 19. Remove Nth Node From End of List

// 끝에서 n 번째의 노드를 단일 순회로 찾기 위해 
// 2 pointer 기법 활용. 2개의 포인터 중 하나를 n+1 만큼 앞세운뒤 같이 끝까지 이동하면
// 나머지 포인터의 next 가 뒤에서 n 번째 노드가 됨.


// Medium
// Topics
// Companies
// Hint
// Given the head of a linked list, remove the nth node from the end of the list and return its head.

 

// Example 1:


// Input: head = [1,2,3,4,5], n = 2
// Output: [1,2,3,5]
// Example 2:

// Input: head = [1], n = 1
// Output: []
// Example 3:

// Input: head = [1,2], n = 1
// Output: [1]
 

// Constraints:

// The number of nodes in the list is sz.
// 1 <= sz <= 30
// 0 <= Node.val <= 100
// 1 <= n <= sz
 

// Follow up: Could you do this in one pass?


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        
        // first 포인터를 n+1 노드 만큼 앞으로 이동
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }
        
        // first와 second를 동시에 이동
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        
        // second가 가리키는 노드의 다음 노드를 제거
        second.next = second.next.next;
        
        return dummy.next;
    }
}
