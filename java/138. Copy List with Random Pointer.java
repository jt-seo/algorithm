// 138. Copy List with Random Pointer

// Random pointer 가 있는 Linked List 를 복제하는 문제
// 각 노드에 해당하는 새 노드를 할당해서 HashMap 에 Node 를 키로 새 노드를 Value 로 mapping.
// next 와 random 포인터를 HashMap 에서 대응하는 새 노드를 찾아서 넣어주면 된다.

// Medium
// Topics
// Companies
// Hint
// A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.

// Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.

// For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.

// Return the head of the copied linked list.

// The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

// val: an integer representing Node.val
// random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
// Your code will only be given the head of the original linked list.


import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;
    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        
        Map<Node, Node> map = new HashMap<>();
        
        // 1단계: 원본 리스트 순회 및 노드 복사
        Node current = head;
        while (current != null) {
            map.put(current, new Node(current.val));
            current = current.next;
        }
        
        // 2단계: 원본 리스트 재순회 및 포인터 설정
        current = head;
        while (current != null) {
            Node clonedNode = map.get(current);
            clonedNode.next = map.get(current.next);
            clonedNode.random = map.get(current.random);
            current = current.next;
        }
        
        // 3단계: 새 리스트의 헤드 반환
        return map.get(head);
    }
}
