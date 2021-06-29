class LRUCache {

    private Deque<Integer> deque;
    private HashMap<Integer, Integer> map;
    private final int CACHE_SIZE;
    public LRUCache(int capacity) {
        deque=new LinkedList<>();
        map=new HashMap<>();
        this.CACHE_SIZE=capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            deque.remove(key);
            deque.push(key);
            return map.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key)){
            if(deque.size()==CACHE_SIZE){
                int last=deque.removeLast();
                map.remove(last);
            }
        }else{
            deque.remove(key);
        }
        deque.push(key);
        map.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
