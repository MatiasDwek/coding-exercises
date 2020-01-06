package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveFromEnd {
    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = null;
        
        ListNode result = removeNthFromEnd(one, 4);
        System.out.println(1);
    }
    
    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return head;
        Deque<ListNode> queue = new LinkedList<>();
        ListNode it = head;
        while (it != null) {
            if (queue.size() != n+1) {
                queue.addLast(it);
            } else {
                queue.removeFirst();
                queue.addLast(it);
            }
            it = it.next;
        }
        
        if (queue.size() == n+1) {
            ListNode prev = queue.pollFirst();
            ListNode nth = queue.pollFirst();
            prev.next = nth.next;
        } else {
            queue.pollFirst();
            return queue.pollFirst();
        }
        
        
        return head;
    }
}
