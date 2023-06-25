/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * The cache is initialized with a positive capacity.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
 *
 * LRUCache cache = new LRUCache( 2 capacity );
        *
        *cache.put(1,1);
        *cache.put(2,2);
        *cache.get(1);       // returns 1
        *cache.put(3,3);    // evicts key 2
        *cache.get(2);       // returns -1 (not found)
        *cache.put(4,4);    // evicts key 1
        *cache.get(1);       // returns -1 (not found)
        *cache.get(3);       // returns 3
        *cache.get(4);       // returns 4
 */

class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

// only need addToFront and Delete
class LRUCache {

    Map<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;

    // initializ a <capacity> size data sctructure with two empty nodes pointing to each other (head and tail)
    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    // move the current node to head, O(1)
    public void moveToHead(Node curr) {
        curr.next = head.next;
        curr.prev = head;
        head.next = curr;
        curr.next.prev = curr;
    }

    // delete the current node, O(1)
    public void delete(Node curr) {
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
    }

    // when getting this node, delete it and move it to head because it is recently used, O(1)
    public int get(int key) {
        if(map.containsKey(key)) {
            Node curr = map.get(key);
            delete(curr);
            moveToHead(curr);
            return curr.val;
        }
        return -1;
    }

    // puts a new node if it doesn't already exist. Regardless of if it already exists, this node is brough to head
    // because it is recently used. If capacity exceeds, remove the tail because it is the least used, O(1)
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node curr = map.get(key);
            curr.val = value;
            delete(curr);
            moveToHead(curr);
        }
        else if(map.size()<capacity) {
            map.put(key, new Node(key, value));
            moveToHead(map.get(key));
        }
        else {
            map.put(key, new Node(key, value));
            map.remove(tail.prev.key);
            delete(tail.prev);
            moveToHead(map.get(key));
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

/**
 * Time: O(1) for everything
 * Space: O(capacity)
 *
 * Intuition:
 * 1. to ensure get operation is O(1), hashmap is used
 * 2. put at worst case involves, inserting new and deleting least recently used.
 *   - For inserting new, hashmap is also O(1)
 *   - For deleteing least recently used, the least recently used has to be tracked, so this involves keeping and
 *     modifying the ordering of the cached values. This is where doubly linked list can be used, where moving places,
 *     swapping or deletion are all O(1) when I can access each node through a hashmap
 */




 
//-----------------------------



/*class LRUCache {
    
    Static class Node {
        Node prev;
        Node next;
        Node key;
        Node data;
    }
    Node head;
    Node tail;
    Node cap;
    Node size;
    HashMap<Integer, Node> map = new HashMap<>();
    void addFront(int key, int val){

    }
    void remove(Node node){
        
    }
    void removeLast(){

    }
    //----------
    public LRUCache(int capacity) {
        this.cap = capacity;
        this.size = 0;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);

            remove(node);
            addFront(key, node.data);
            map.put(key, head);

            return node.data;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
        }else{
            if(size == cap){
                map.remove(tail.key);
                removeLast();
            }
        }
        addFront(key, val);
        map.put(key, head);      
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */ */