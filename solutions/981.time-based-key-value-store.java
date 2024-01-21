/*
 * @lc app=leetcode id=981 lang=java
 *
 * [981] Time Based Key-Value Store
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class TimeMap {

    Map<String, List<Map.Entry<Integer, String>>> store;

    public TimeMap() {
        store = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        store.computeIfAbsent(key, k -> new ArrayList<>()).add(Map.entry(timestamp, value));
    }

    public String get(String key, int timestamp) {
        String result = "";
        List<Map.Entry<Integer, String>> timeStore = store.get(key);
        if (timeStore != null) {
            result = binarySearch(timeStore, timestamp);
        }
        return result;
    }

    private String binarySearch(List<Map.Entry<Integer, String>> timeStore, int timestamp) {
        String res = "";
        int begin = 0;
        int end = timeStore.size() - 1;
        while (begin <= end) {
            int middle = (begin + end) >>> 1;
            if (timeStore.get(middle).getKey() <= timestamp) {
                res = timeStore.get(middle).getValue();
                begin = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return res;
    }
}

class TimeMap_TreeMap {

    Map<String, TreeMap<Long, String>> store;

    public TimeMap_TreeMap() {
        store = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Long, String> timeStore = store.getOrDefault(key, new TreeMap<>());
        timeStore.put(Long.valueOf(timestamp), value);
        store.put(key, timeStore);
    }

    public String get(String key, int timestamp) {
        String result = "";
        TreeMap<Long, String> timeStore = store.get(key);
        if (timeStore != null) {
            Map.Entry<Long, String> entry = timeStore.floorEntry(Long.valueOf(timestamp));
            if (entry != null) {
                result = entry.getValue();
            }
        }
        return result;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
// @lc code=end

