//https://leetcode.com/problems/lru-cache/description/
class LRUCache {
    class DLinkNode {
        int key,value;
        DLinkNode pre,post;
        public DLinkNode(){
            this.pre=null;
            this.post=null;
            this.key=0;
            this.value=0;
        }

        public DLinkNode(int key,int value){
            this.key=key;
            this.value=value;
            this.pre=null;
            this.post=null;
        }
    }

    private Map<Integer,DLinkNode> cache;
    private DLinkNode head, tail;
    private int capacity;
    private int count;

    public LRUCache(int capacity) {
       cache=new HashMap<>();
       this.count=0;
        this.capacity=capacity;
        this.head=new DLinkNode();
        this.tail=new DLinkNode();
        this.head.post=tail;
        this.tail.pre=head;
    }

    //Add node to the start
    private void addNode(DLinkNode node){
        node.pre=head;
        node.post=head.post;
        head.post.pre=node;
        head.post=node;
    }

    //Remove the specified list from DLinkList
    private void removeNode(DLinkNode node){
       DLinkNode pre=node.pre;
       DLinkNode post=node.post;

       pre.post=post;
       post.pre=pre;
    }

    //Move the specified node to the start of DLinkList
    private void moveToHead(DLinkNode node){
        this.removeNode(node);
        this.addNode(node);
    }

    private DLinkNode popTail(){
        DLinkNode node=tail.pre;
        this.removeNode(node);

        return node;
    }
    
    public int get(int key) {
       DLinkNode node=cache.get(key);
       if(node==null){
           return -1;
       }
       this.moveToHead(node);
       return node.value;
    }
    
    public void put(int key, int value) {
        DLinkNode node=cache.get(key);

        //Cache miss
        if(node==null){
            DLinkNode newNode=new DLinkNode(key,value);
            this.addNode(newNode);
            cache.put(key,newNode);
            count++;
        }else{
            node.value=value;
            this.moveToHead(node);
        }
        if(count>capacity){
            DLinkNode poppedNode=this.popTail();
            cache.remove(poppedNode.key);
            count--;
        }
        
    }

   
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
