package datastructures.hashtable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class Hashtable<K, V> {
  private static final int DEFAULT_CAPACITY = 16;
  private ArrayList<LinkedList<Entry<K, V>>> table;
  private int size;

  public Hashtable() {
    this(DEFAULT_CAPACITY);
  }

  public Hashtable(int capacity) {
    table = new ArrayList<>(capacity);
    for (int i = 0; i < capacity; i++) {
      table.add(null);
    }
    size = 0;
  }

  public void set(K key, V value) {
    int index = hash(key);
    LinkedList<Entry<K, V>> bucket = table.get(index);

    if (bucket == null) {
      bucket = new LinkedList<>();
      table.set(index, bucket);
    }

    Entry<K, V> entry = findEntry(bucket, key);

    if (entry == null) {
      bucket.add(new Entry<>(key, value));
      size++;
    } else {
      entry.setValue(value);
    }
  }

  public V get(K key) {
    int index = hash(key);
    LinkedList<Entry<K, V>> bucket = table.get(index);

    if (bucket != null) {
      Entry<K, V> entry = findEntry(bucket, key);

      if (entry != null) {
        return entry.getValue();
      }
    }

    return null;
  }

  public boolean has(K key) {
    int index = hash(key);
    LinkedList<Entry<K, V>> bucket = table.get(index);

    if (bucket != null) {
      Entry<K, V> entry = findEntry(bucket, key);
      return entry != null;
    }

    return false;
  }

  public Collection<K> keys() {
    ArrayList<K> keys = new ArrayList<>();

    for (LinkedList<Entry<K, V>> bucket : table) {
      if (bucket != null) {
        for (Entry<K, V> entry : bucket) {
          keys.add(entry.getKey());
        }
      }
    }

    return keys;
  }

  public int hash(K key) {
    return Math.abs(key.hashCode()) % table.size();
  }

  private Entry<K, V> findEntry(LinkedList<Entry<K, V>> bucket, K key) {
    for (Entry<K, V> entry : bucket) {
      if (entry.getKey().equals(key)) {
        return entry;
      }
    }

    return null;
  }

  private static class Entry<K, V> {
    private K key;
    private V value;

    public Entry(K key, V value) {
      this.key = key;
      this.value = value;
    }

    public K getKey() {
      return key;
    }

    public V getValue() {
      return value;
    }

    public void setValue(V value) {
      this.value = value;
    }
  }
}
