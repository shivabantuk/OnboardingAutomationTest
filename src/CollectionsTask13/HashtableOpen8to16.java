package CollectionsTask13;

import java.util.Arrays;

public class HashtableOpen8to16<K,V> {
    private static final int INITIAL_CAPACITY = 8;
    private static final int MAXIMUM_CAPACITY = 16;
    private static final double LOAD_FACTOR = 1.0;

    private K[] keys;
    private V[] values;
    private int size;
    private int capacity;
    public HashtableOpen8to16() {
        this.capacity = INITIAL_CAPACITY;
        keys = (K[]) new Object[capacity];
        values = (V[]) new Object[capacity];
        size = 0;
    }

    private int hash(K key){
        return (key.hashCode() &  0x7fffffff) % capacity;

    }

    private void resize(int newCapacity) {
        HashtableOpen8to16<K,V> temp = new HashtableOpen8to16();
        temp.capacity = newCapacity;
        temp.keys = (K[]) new Object[newCapacity];
        temp.values = (V[]) new Object[newCapacity];
        temp.size = 0;
        for(int i = 0; i < capacity; i++){
            if(keys[i] == null){
                temp.insert(keys[i],values[i]);
            }
        }
        this.keys = temp.keys;
        this.values = temp.values;
        this.capacity = temp.capacity;
    }
    public void insert(K key,V value){
        if(size == MAXIMUM_CAPACITY){
            throw new IllegalStateException("Maximum capacity exceeded");
        }
        if((size + 1.0) / capacity >= LOAD_FACTOR){
            if(capacity < MAXIMUM_CAPACITY)
                resize(capacity * 2);
        }
        int idx = hash(key);
        while(keys[idx]!=null){
            if(keys[idx].equals(key)){
                values[idx] = value;
                return;
            }
            idx = (idx+1) % capacity;
        }
        keys[idx] = key;
        values[idx] = value;
        size++;
    }
    public V get(K key){
        int idx = hash(key);
        int start = idx;
        while (keys[idx] != null){
            if (keys[idx].equals(key)){
                return values[idx];
            }
            idx = (idx +1 ) % capacity;
            if(idx == start) break;
        }
        return null;
    }
    public void remove(K key){
        int idx = hash(key);
        while(keys[idx] != null){
            if(keys[idx].equals(key)){
                keys[idx] = null;
                values[idx] = null;
                size--;

                idx = (idx +1 ) % capacity;
                while(keys[idx] != null){
                    K rehashKey = keys[idx];
                    V rehashValue = values[idx];
                    keys[idx] = null;
                    values[idx] = null;
                    size--;
                    insert(rehashKey, rehashValue);
                    idx = (idx + 1)%capacity;

                }
                if(capacity > INITIAL_CAPACITY&&size <= capacity/4) {
                    resize(Math.max(INITIAL_CAPACITY, capacity / 2));
                }
                return;
                }
            idx = (idx+1)%capacity;
            }
        }
        public int size(){
        return size;
        }
        public K[] keys(){
        return Arrays.stream(keys).filter(k->k!=null).toArray(size -> (K[]) new Object[size]);
        }
    }

