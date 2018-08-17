/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        
        // slow fast to find middle point
        ListNode slow = head; 
        ListNode fast = head; 
        ListNode prev = head;
        
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // clean up
        prev.next = null;
        
        // reverse and weaving
        ListNode then = null;
        ListNode curr = head;
        ListNode next = reverse(slow, fast);
        
        while (curr != null && next != null) {
            then = curr.next;
            
            curr.next = next;
            
            curr = next;
            next = then;
        }
    }
    
    public ListNode reverse(ListNode head, ListNode tail) {
        ListNode prev = null, curr = head;
        
        while (curr != null) {
            ListNode next = curr.next;
            
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}