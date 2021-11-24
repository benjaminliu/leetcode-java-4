package com.ben.tree.ntree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class _0341_Flatten_Nested_List_Iterator {


    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }


    public static class NestedIterator implements Iterator<Integer> {

        private List<Integer> data;
        private int current;

        public NestedIterator(List<NestedInteger> nestedList) {
            data = new ArrayList<>();
            current = 0;
            if (nestedList != null) {
                for (NestedInteger ni : nestedList) {
                    traverse(ni, data);
                }
            }
        }

        private void traverse(NestedInteger nestedInteger, List<Integer> data) {
            if (nestedInteger.isInteger()) {
                data.add(nestedInteger.getInteger());
            } else {
                for (NestedInteger ni : nestedInteger.getList()) {
                    traverse(ni, data);
                }
            }
        }

        @Override
        public Integer next() {
            return data.get(current++);
        }

        @Override
        public boolean hasNext() {
            if (current < data.size()) {
                return true;
            }
            return false;
        }
    }

    public static class NestedIterator1 implements Iterator<Integer> {

        private LinkedList<NestedInteger> data;

        public NestedIterator1(List<NestedInteger> nestedList) {
            data = new LinkedList<>(nestedList);
        }

        @Override
        public Integer next() {
            return data.remove(0).getInteger();
        }

        @Override
        public boolean hasNext() {
            while (!data.isEmpty() && !data.get(0).isInteger()) {
                List<NestedInteger> first = data.remove(0).getList();
                for (int i = first.size() - 1; i >= 0; i--) {
                    data.addFirst(first.get(i));
                }
            }
            return !data.isEmpty();
        }
    }
}
