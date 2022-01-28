package com.ben.datastructure;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class _0146_LRU_Cache {

    class Solution1 {
        class Node {
            public int key;
            public int val;
            public Node next;
            public Node pre;

            public Node(int k, int v) {
                this.key = k;
                this.val = v;
            }
        }

        class DoubleList {
            private Node head;
            private Node tail;
            private int size;

            public DoubleList() {
                this.head = new Node(0, 0);
                this.tail = new Node(0, 0);
                this.head.next = tail;
                this.tail.pre = head;
                this.size = 0;
            }

            public void addLast(Node x) {
                x.pre = tail.pre;
                x.next = tail;

                tail.pre.next = x;
                tail.pre = x;
                size++;
            }

            public void remove(Node x) {
                x.pre.next = x.next;
                x.next.pre = x.pre;
                size--;
            }

            public Node removeFirst() {
                if (head.next == tail) {
                    return null;
                }

                Node first = head.next;
                remove(first);
                return first;
            }

            public int size() {
                return size;
            }
        }

        class LRUCache {

            private int capacity;
            private DoubleList cache;
            private Map<Integer, Node> map;

            public LRUCache(int capacity) {
                this.capacity = capacity;
                this.map = new HashMap<>();
                this.cache = new DoubleList();
            }

            public int get(int key) {
                if (!map.containsKey(key)) {
                    return -1;
                }

                makeRecently(key);
                return map.get(key).val;
            }

            public void put(int key, int value) {
                if (map.containsKey(key)) {
                    deleteKey(key);
                    addRecently(key, value);
                    return;
                }

                if (capacity == cache.size()) {
                    removeLeastRecently();
                }
                addRecently(key, value);
            }

            private void makeRecently(int key) {
                Node x = map.get(key);
                cache.remove(x);
                cache.addLast(x);
            }

            private void addRecently(int key, int val) {
                Node x = new Node(key, val);
                cache.addLast(x);
                map.put(key, x);
            }

            private void deleteKey(int key) {
                Node x = map.get(key);
                cache.remove(x);
                map.remove(key);
            }

            private void removeLeastRecently() {
                Node least = cache.removeFirst();
                map.remove(least.key);
            }
        }
    }

    class Solution2 {
        class LRUCache {
            int cap;
            LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

            public LRUCache(int capacity) {
                this.cap = capacity;
            }

            public int get(int key) {
                if (!cache.containsKey(key)) {
                    return -1;
                }

                makeRecently(key);
                return cache.get(key);
            }

            public void put(int key, int val) {
                if (cache.containsKey(key)) {
                    cache.put(key, val);
                    makeRecently(key);
                    return;
                }

                if (cache.size() == this.cap) {
                    int oldestKey = cache.keySet().iterator().next();
                    cache.remove(oldestKey);
                }

                cache.put(key, val);
            }

            private void makeRecently(int key) {
                int val = cache.get(key);
                cache.remove(key);
                cache.put(key, val);
            }
        }
    }
}
