/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1), walk = head;
        int carry = 0, reminder = 0;
        
        while (l1 != null || l2 != null) {
            int sum = carry;
            
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            carry    = sum / 10;
            reminder = sum % 10;
            
            walk.next = new ListNode(reminder);
            walk = walk.next;
        }

        if (carry != 0) {
            walk.next = new ListNode(carry);
        }
        
        return head.next;
    }
}