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
        Stack<ListNode> s = new Stack<>();
        ListNode curr = new ListNode(0), head = curr;
        int m = 0, n = 0;

        // cal length
        for (ListNode node = l1; node != null; node = node.next) m++;
        for (ListNode node = l2; node != null; node = node.next) n++;
        
        System.out.println(m);
        System.out.println(n);
        
        // align
        while (m > n || n > m) {
            int val = m > n? l1.val: l2.val;

            curr.next = new ListNode(val);
            curr = curr.next;
            s.push(curr);
            
            if (m > n) {
                l1 = l1.next;
                m--;
            }
            if (n > m) {
                l2 = l2.next;
                n--;
            }
        }
        
        // pass
        int carry = 0, reminder = 0;
        while (n != 0 && m != 0) {
            int sum = l1.val + l2.val + carry;
            reminder = sum % 10;
            carry    = sum / 10;
            
            while (carry > 0) {
                if (s.isEmpty()) {
                    head.val = carry;
                    carry = 0;
                    break;
                }
                
                ListNode node = s.pop();
                
                int tmp = node.val + carry;
                node.val = tmp % 10;
                carry    = tmp / 10;
            }
            
            curr.next = new ListNode(reminder);
            curr = curr.next;
            s.push(curr);
            
            l1 = l1.next;
            l2 = l2.next;
            n--;
            m--;
        }
        
        return head.val == 0? head.next: head;
    }
}