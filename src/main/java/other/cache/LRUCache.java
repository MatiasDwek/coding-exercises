package other.cache;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache<K, V> implements Cache<K, V> {
    private int maxSize;
    private Map<K, V> map;
    private Deque<K> queue;
    
    public LRUCache(int size) {
        this.maxSize = size;
        map = new HashMap<>();
        queue = new LinkedList<>();
    }
    
    @Override
    public void put(K key, V value) {
        if (maxSize == 0)
            return;
        if (!map.containsKey(key)) {
            if (queue.size() == maxSize) {
                K last = queue.removeLast();
                map.remove(last);
            }
            map.put(key, value);
        } else {
            queue.remove(key);
        }
        queue.addFirst(key);
    }
    
    @Override
    public V get(K key) {
        return map.get(key);
    }
    
    @Override
    public int size() {
        return queue.size();
    }
    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (V value : map.values())
            result.append(value.toString() + " ");
        return result.toString();
    }
    
    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);
        
        cache.put(1, "one");
        cache.put(2, "two");
        cache.put(6, "six");
        cache.put(2, "two");
        cache.put(2, "two");
        cache.put(6, "six");
        
        cache.put(2, "two");
        cache.put(7, "seven");
        cache.put(8, "eight");
        cache.put(6, "six");
        cache.put(6, "six");
        
        System.out.println(cache.get(8));
    }
    
}
