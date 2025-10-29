import java.util.HashMap;
import java.util.Map;

public class LRUcache<V>{
    private final int maxSize;
    private final HashMap<String, Node>cache;
    private final DoublyList cacheList;
    private int currSize;

    public LRUcache(int maxSize){
        this.maxSize = maxSize;
        this.cache = new HashMap<>();
        this.cacheList = new DoublyList();
        this.currSize = 0;
    }

    public V get(String key){
        Node node = cache.get(key);
        if(node == null){
            return null;
        }
        cacheList.pushFront(node);
        System.out.println("Accessed key: " + key + " → moved to front");
        displaycacheOrder();
        System.out.println();
        return cache.get(key).val;
    }

    public void put(String key, V val){
        Node exist = cache.get(key);

        if(exist != null){
            exist.val = val;
            cacheList.pushFront(exist);
            System.out.println("Updated key: " + key + " → moved to front");
            System.out.println();
            return;
        }

        if(currSize == maxSize){
            String oldKey = cacheList.getLastKey();
            cacheList.removeLast();
            cache.remove(oldKey);
            currSize--;
            System.out.println("Removed least recently used key: " + oldKey);
            System.out.println();
        }

        Node newNode = new Node(key ,val);
        cacheList.addFront(newNode);
        cache.put(key, newNode);
        currSize++;

        System.out.println("Added key: " + key);
        displaycacheOrder();
        System.out.println();
    }

    private class Node{
        String key;
        V val;
        Node next , prev;

        Node(String key , V val){
            this.key = key;
            this.val = val;
        }
    }

    private class DoublyList{
        private Node front, back;

        void pushFront(Node node){
            if(node == front){
                return;
            }

            if(node ==back){
                back =back.prev;
                back.next =null;
            }else{
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            node.prev = null;
            node.next = front;
            front.prev = node;
            front = node;
        }

        void addFront(Node node){
            if(front != null){
                node.next = front;
                front.prev = node;
                front= node;
                return;
            }
            front=back=node;
        }

        void removeLast(){
            if(back ==null){
                return;
            }
            if(front==back){
                front= back = null;
                return;
            }
            back=back.prev;
            back.next = null;
        }

        String getLastKey(){
            return back.key;
        }
    }

    private void displaycacheOrder(){
        Node temp = cacheList.front;
        System.out.print("cache order (front -> back) ");
        while(temp !=null){
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        LRUcache<Integer> cache = new LRUcache<>(5);
        cache.put("luffy", 19);
        cache.put("zoro", 13);
        cache.put("sanji", 37);
        cache.put("ussop", 40);
        cache.get("zoro");
        cache.put("chopper", 52);
        cache.get("luffy");
        cache.put("franky", 29);
        cache.get("sanji");

        System.out.println("\nFinal cache keys: " + cache.cache.keySet());
    }
}