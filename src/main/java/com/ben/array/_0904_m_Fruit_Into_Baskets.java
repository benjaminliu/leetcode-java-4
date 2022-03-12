package com.ben.array;

import com.ben.util.PrintUtil;

import java.util.HashMap;

public class _0904_m_Fruit_Into_Baskets {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        PrintUtil.printLn(new Solution().totalFruit(nums));
    }

    static class Solution {
        public int totalFruit(int[] fruits) {
            int start = 0;
            int maxLen = 1;
            int idx = 0;

            HashMap<Integer, Integer> types = new HashMap<>();

            while (idx < fruits.length && types.size() < 2) {
                addToMap(types, fruits[idx]);
                idx++;
            }

            for (int i = idx; i < fruits.length; i++) {
                int toAdd = fruits[i];
                addToMap(types, toAdd);

                if (types.size() > 2) {
                    int len = i - start;
                    if (len > maxLen) {
                        maxLen = len;
                    }

                    do {
                        int toRemove = fruits[start];
                        removeFromMap(types, toRemove);
                        start++;
                    } while (types.size() > 2);
                }
            }

            int len = fruits.length - start;
            if (len > maxLen) {
                maxLen = len;
            }

            return maxLen;
        }

        private void addToMap(HashMap<Integer, Integer> map, int key) {
            int val = map.getOrDefault(key, 0);
            val++;
            map.put(key, val);
        }

        private void removeFromMap(HashMap<Integer, Integer> map, int key) {
            int val = map.get(key);
            val--;
            if (val == 0) {
                map.remove(key);
            } else {
                map.put(key, val);
            }
        }
    }

    static class Solution2 {
        public int totalFruit(int[] fruits) {
            //Most recent fruit type
            int recentFruitType = -1;
            int recentTypeCount = 0;

            //the fruit type of the other basket
            int theOtherFruitType = -1;

            int max = 0;

            int curMax = 0;

            for (int fruit : fruits) {
                if (fruit == recentFruitType || fruit == theOtherFruitType) {
                    curMax++;
                } else {
                    curMax = recentTypeCount + 1;
                }

                if (fruit == recentFruitType) {
                    //current tree has same type with lastTree, recentFruitCount increase by 1
                    recentTypeCount++;
                } else {
                    //current tree's type is different from lastTree, so the recentFruitCount should be 1
                    recentTypeCount = 1;

                    theOtherFruitType = recentFruitType;
                    recentFruitType = fruit;
                }

                max = Math.max(max, curMax);
            }

            return max;
        }
    }
}
