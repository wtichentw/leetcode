class LFUCache {
    Map<Integer, Integer> keyToVal;
    Map<Integer, Integer> keyToCnt;
    Map<Integer, LinkedHashSet<Integer>> cntToLayerKey;
    int capacity;
    int min;
    
    public LFUCache(int capacity) {
        this.keyToVal = new HashMap<>();
        this.keyToCnt = new HashMap<>();
        this.cntToLayerKey = new HashMap<>();
        this.capacity = capacity;
        this.min = 1;
        
        cntToLayerKey.put(1, new LinkedHashSet<Integer>());
    }
    
    public int get(int key) {
        if (!keyToVal.containsKey(key)) return -1;
        
        // update cnt 
        int cnt = keyToCnt.get(key);
        cntToLayerKey.get(cnt).remove(key);
        putCnt(key, cnt + 1);
        
        // update min
        if (cnt == min && cntToLayerKey.get(cnt).size() == 0) {
            min++;
        }
        
        return keyToVal.get(key);
    }
    
    public void put(int key, int value) {
        if (capacity <= 0) return;
        
         // old key 
        if (keyToVal.containsKey(key)) {
            // update val
            putVal(key, value);
            
            // update cnt
            get(key);
        }
        
        // new key
        else {
            if (isFull()) evict();
        
            min = 1;
            putCnt(key, min); // adding new key and count
            putVal(key, value);
        }
    }
    
    public void evict() {
        int ekey = cntToLayerKey.get(min).iterator().next();
        
        removeVal(ekey);
        cntToLayerKey.get(min).remove(ekey);
    }
    
    public void removeVal(int key) {
        keyToVal.remove(key);
    }
    
    public void putVal(int key, int val) {
        keyToVal.put(key, val); // adding new key and value
    }
    
    public void putCnt(int key, int cnt) {
        keyToCnt.put(key, cnt);
        cntToLayerKey.putIfAbsent(cnt, new LinkedHashSet<Integer>());
        cntToLayerKey.get(cnt).add(key);
    }
    
    public boolean isFull() {
        return keyToVal.size() >= capacity;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */