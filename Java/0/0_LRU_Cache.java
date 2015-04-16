public class LRUCache {
    
    private int capacity;
    private Map<Integer, DoubleLinkedList> map = new HashMap<>();
    private DoubleLinkedList head = null;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public void attach(DoubleLinkedList node) {
        if (head == null) {
            node.next = node;
            node.prev = node;
        } else {
            DoubleLinkedList last = head.prev;
            
            head.prev = node;
            node.next = head;
            
            last.next = node;
            node.prev = last;
        }
        head = node;
    }
    
    public void detach(DoubleLinkedList node) {
        if (node == head) {
            head = node.next;    
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            DoubleLinkedList node = map.get(key);
            detach(node);
            attach(node);
            return node.val;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if (!map.containsKey(key)) {
            DoubleLinkedList node = new DoubleLinkedList(key, value);
            if (capacity == map.size()) {
                DoubleLinkedList last = head.prev;
                detach(last);
                map.remove(last.key);
            }
            attach(node);
            map.put(key, node);
        } else {
            DoubleLinkedList node = map.get(key);
            node.val = value;
            detach(node);
            attach(node);
        }
    }
}

class DoubleLinkedList {
    DoubleLinkedList prev;
    DoubleLinkedList next;
    int key;
    int val;
    
    public DoubleLinkedList(int key, int val) {
        this.key = key;
        this.val = val;
    }
}