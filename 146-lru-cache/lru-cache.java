class LRUCache {
    class Node{
        int val,key;
        Node prev,next;
        Node(int k,int v){
            val = v;
            key = k;
        }
    }
    public Node head,tail;
    public int cap;
    public Map<Integer,Node> mp;


    public LRUCache(int capacity) {
        this.cap = capacity;
        mp = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void ins(Node node){
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }
    
    public int get(int key) {
        if(!mp.containsKey(key)) return -1;
        Node node = mp.get(key);
        remove(node);
        ins(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (mp.containsKey(key)) {
            remove(mp.get(key));
        }

        Node node = new Node(key, value);
        ins(node);
        mp.put(key, node);

        if (mp.size() > cap) {
            Node lru = tail.prev;
            remove(lru);
            mp.remove(lru.key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */