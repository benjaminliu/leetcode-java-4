package com.ben.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _0049_m_Group_Anagrams {

    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();

            for (String str : strs) {
                int[] dic = new int[26];
                for (Character c : str.toCharArray()) {
                    int key = c - 'a';
                    dic[key] = dic[key] + 1;
                }

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < dic.length; i++) {
                    int val = dic[i];
                    if (val > 0) {
                        sb.append(i + 'a').append(val);
                    }
                }

                String strKey = sb.toString();
                List<String> list = map.getOrDefault(strKey, new ArrayList<>());
                list.add(str);
                map.put(strKey, list);
            }

            return new ArrayList<>(map.values());
        }
    }
}
