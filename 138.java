/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode w1, w2; 
        
        // copy next
        w1 = head; 
        w2 = dummy;
        while (w1 != null) {
            w2.next = new RandomListNode(w1.label);
            map.put(w1, w2.next);
            
            w1 = w1.next;
            w2 = w2.next;
        }
        
        // copy random
        w1 = head; 
        w2 = dummy.next;
        while (w1 != null) {
            w2.random = map.get(w1.random);
            
            w1 = w1.next;
            w2 = w2.next;
        }
        
        return dummy.next;
    }
}