package leetcode;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs
 */
public class SwapNodes {
    
    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        
        one.next = two;
        two.next = three;
        three.next = null;
        four.next = null;
        
        swapPairs(one);
    }
    
    public static ListNode swapPairsRec(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        ListNode nextNode = head.next;
        head.next = swapPairs(nextNode.next);
        nextNode.next = head;
        return nextNode;
    }

    
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode nodeOne = head;
        head = head.next;
        ListNode nodeZero = null;
        while (nodeOne != null) {
            ListNode nodeTwo = nodeOne.next;
            
            if (nodeZero != null) {
                if (nodeTwo != null)
                    nodeZero.next = nodeTwo;
                else {
                    nodeZero.next = nodeOne;
                    break;
                }
            }

            nodeOne.next = nodeTwo.next;
            nodeTwo.next = nodeOne;
            
            nodeZero = nodeOne;
            nodeOne = nodeOne.next;
        }
        
        return head;
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
        
        @Override
        public String toString() {
            return Integer.toString(val);
        }
    }
}
