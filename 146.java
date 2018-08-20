class LRUCache {
    class DLinkNode {
        int key;
        int val;
        DLinkNode prev;
        DLinkNode next; 
    }
    
    Map<Integer, DLinkNode> cache = new HashMap<>();
    int capacity;
    int count;
    DLinkNode head;
    DLinkNode tail;
    
    public void addNode(DLinkNode node) {
        node.next = head.next;
        node.prev = head;
        
        head.next.prev = node;
        head.next = node;
    }
    
    public void removeNode(DLinkNode node) {
        DLinkNode prev = node.prev;
        DLinkNode next = node.next;
        
        prev.next = next;
        next.prev = prev;
    }
    
    public void moveToHead(DLinkNode node) {
        removeNode(node);
        addNode(node);
    }
    
    public DLinkNode popTail() {
        DLinkNode ret = tail.prev;
        removeNode(ret);
        return ret;
    }
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        
        head = new DLinkNode();
        tail = new DLinkNode();
        
        head.next = tail;
        head.prev = null;
        tail.next = null;
        tail.prev = head;
    }
    
    public int get(int key) {
        DLinkNode node = cache.get(key);
        
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        
        return node.val;
    }
    
    public void put(int key, int value) {
        DLinkNode node = cache.get(key);
        
        if (node == null) {
            
            DLinkNode newNode = new DLinkNode();
            newNode.key = key;
            newNode.val = value;
            
            cache.put(key, newNode);
            addNode(newNode);
            
            if (++count > capacity) {
                DLinkNode tail = popTail();
                cache.remove(tail.key);
                count--;
            }
        } else {
            node.val = value;
            moveToHead(node);
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */