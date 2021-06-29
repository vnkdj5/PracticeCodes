class LRUCache {

    private Set<Integer> cache;
    private HashMap<Integer, Integer> map;
    private final int CACHE_SIZE;
    public LRUCache(int capacity) {
        cache=new LinkedHashSet<>();
        map=new HashMap<>();
        this.CACHE_SIZE=capacity;
    }
    
    public int get(int key) {
        if(cache.contains(key)){
            cache.remove(key);
            cache.add(key);
            return map.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(get(key)==-1){
          if(cache.size()==CACHE_SIZE){
            int firstKey = cache.iterator().next();
            cache.remove(firstKey);
          }
            cache.add(key);
          
    }
          map.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
