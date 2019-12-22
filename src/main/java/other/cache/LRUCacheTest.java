package other.cache;
//package cache;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import stuff.LRUCache;
//
//@DisplayName("Tests for the LRUCache")
//class LRUCacheTest {
//
//    @Test
//    void GetSize_EmptyCache_ShouldBeEmpty() {
//        LRUCache<Integer, String> cache = new LRUCache<>(3);
//        
//        assertEquals(cache.size(), 0);
//    }
//    
//    @Test
//    void GetElement_EmptyCache_ShouldReturnNull() {
//        LRUCache<Integer, String> cache = new LRUCache<>(3);
//        
//        assertEquals(cache.get(5), null);
//    }
//    
//    @Test
//    void GetElement_ElementAdded_ShouldReturnElement() {
//        LRUCache<Integer, String> cache = new LRUCache<>(3);
//        Integer key = 5;
//        String value = "five";
//        cache.put(key, value);
//        
//        assertEquals(cache.get(key), value);
//    }
//    
//    @Test
//    void GetSize_SameElementAdded_ShouldReturnSameSize() {
//        LRUCache<Integer, String> cache = new LRUCache<>(3);
//        Integer key = 5;
//        String value = "five";
//        cache.put(key, value);
//        int sizePrev = cache.size();
//        cache.put(key, value);
//        cache.put(key, value);
//        int sizePost = cache.size();
//        
//        assertEquals(sizePrev, sizePost);
//    }
//    
//    @Test
//    void GetElement_ElementNoLongerOnCache_ShouldReturnNull() {
//        LRUCache<Integer, String> cache = new LRUCache<>(3);
//        Integer key = 5;
//        String value = "five";
//        cache.put(key, value);
//        cache.put(6, "six");
//        cache.put(7, "seven");
//        cache.put(8, "eight");
//        
//        assertEquals(cache.get(key), null);
//    }
//
//}
