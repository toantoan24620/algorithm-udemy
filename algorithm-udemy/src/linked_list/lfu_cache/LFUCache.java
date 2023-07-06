package linked_list.lfu_cache;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.TreeMap;

class LFUCache {
    private final Map<Integer, Integer> keyToFrequency;
    private final TreeMap<Integer, LinkedHashSet<Integer>> frequencyToKey;
    private final Map<Integer, Integer> keyToValue;
    private final int capacity;

    public LFUCache(int capacity) {
        keyToFrequency = new HashMap<>();
        frequencyToKey = new TreeMap<>();
        keyToValue = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if(keyToValue.containsKey(key)){
            increFrequency(key);
            return keyToValue.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if(capacity == 0) return ;

        if(keyToValue.size() == capacity && !keyToValue.containsKey(key)){
            removeLastFrequencyUsed();
        }

        keyToValue.put(key, value);

        if(keyToFrequency.containsKey(key)){
            increFrequency(key);
        }else{
            keyToFrequency.put(key, 1);
            frequencyToKey.computeIfAbsent(1, p -> new LinkedHashSet<>()).add(key);
        }

    }

    private void increFrequency(int key){
        int frequency = keyToFrequency.get(key);
        keyToFrequency.put(key, frequency + 1);

        // xoá tần xuất xuất hiện của 1 key trong frequencyToKey
        deletePreviousFrequency(key, frequency);

        // check key: frequency + 1 trong frequencyToKey, nếu key đó tồn tại và được gắn  1 gíá trị non-null thì return về giá trị đó
        // còn không thì return về parametter thứ 2 và add key vào danh sách đó.
        frequencyToKey.computeIfAbsent(frequency + 1, p -> new LinkedHashSet<>()).add(key);
    }

    private void deletePreviousFrequency(int key, int frequency){
        LinkedHashSet<Integer> keys = frequencyToKey.get(frequency);
        keys.remove(key);

        if(keys.isEmpty()){
            frequencyToKey.remove(frequency);
        }
    }

    private void removeLastFrequencyUsed(){
        Map.Entry<Integer, LinkedHashSet<Integer>> first = frequencyToKey.firstEntry();
        LinkedHashSet<Integer> keys = first.getValue();

        int key = keys.iterator().next();

        keys.remove(key);
        if(keys.isEmpty()){
            frequencyToKey.remove(first.getKey());
        }
        keyToFrequency.remove(key);
        keyToValue.remove(key);
    }
}
