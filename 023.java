/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    class ListNodeComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode a, ListNode b) {
            return (a.val > b.val)? 1: -1;
        }
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue(new ListNodeComparator());
        
        for (ListNode ln: lists) {
            if (ln != null) pq.offer(ln);    
        }
        
        if (pq.isEmpty()) return null;
        
        ListNode head = pq.poll(), walk = head;
        while (!pq.isEmpty()) {
            if (walk.next != null) pq.offer(walk.next);
            walk.next = pq.poll();
            walk = walk.next;
        }
        
        return head;
    }
}