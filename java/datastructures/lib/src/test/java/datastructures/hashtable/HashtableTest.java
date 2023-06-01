package datastructures.hashtable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;

public class HashtableTest {

  @Test
  public void testSetAndGet() {
    Hashtable<String, Integer> hashtable = new Hashtable<>();
    hashtable.set("key1", 10);

    Assertions.assertEquals(10, hashtable.get("key1"));
  }

  @Test
  public void testSetOverwrite() {
    Hashtable<String, String> hashtable = new Hashtable<>();
    hashtable.set("key1", "value1");
    hashtable.set("key1", "value2");

    Assertions.assertEquals("value2", hashtable.get("key1"));
  }

  @Test
  public void testGetNonexistentKey() {
    Hashtable<String, Integer> hashtable = new Hashtable<>();
    hashtable.set("key1", 10);

    Assertions.assertNull(hashtable.get("nonexistentKey"));
  }

  @Test
  public void testKeys() {
    Hashtable<String, Integer> hashtable = new Hashtable<>();
    hashtable.set("key1", 10);
    hashtable.set("key2", 20);
    hashtable.set("key3", 30);

    Collection<String> keys = hashtable.keys();

    Assertions.assertEquals(3, keys.size());
    Assertions.assertTrue(keys.contains("key1"));
    Assertions.assertTrue(keys.contains("key2"));
    Assertions.assertTrue(keys.contains("key3"));
  }

  @Test
  public void testCollisionHandling() {
    Hashtable<String, Integer> hashtable = new Hashtable<>(4);
    hashtable.set("key1", 10);
    hashtable.set("key5", 20);

    Assertions.assertEquals(10, hashtable.get("key1"));
    Assertions.assertEquals(20, hashtable.get("key5"));
  }

  @Test
  public void testCollisionRetrieval() {
    Hashtable<String, Integer> hashtable = new Hashtable<>(4);
    hashtable.set("key1", 10);
    hashtable.set("key5", 20);
    hashtable.set("key9", 30);

    Assertions.assertEquals(20, hashtable.get("key5"));
    Assertions.assertEquals(30, hashtable.get("key9"));
  }

  @Test
  public void testHashInRange() {
    Hashtable<String, Integer> hashtable = new Hashtable<>(16);
    int hash = hashtable.hash("key");

    Assertions.assertTrue(hash >= 0 && hash < 16);
  }
}
