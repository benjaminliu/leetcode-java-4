package com.ben.graph;

import com.ben.util.PrintUtil;

import java.util.*;

public class _0127_m_Word_Ladder {

    public static void main(String[] args) {

//        String beginWord = "hit";
//        String endWord = "cog";
//        List<String> wordList = new ArrayList<>();
//        wordList.add("hot");
//        wordList.add("dot");
//        wordList.add("dog");
//        wordList.add("lot");
//        wordList.add("log");
//        wordList.add("cog");


        String beginWord = "hot";
        String endWord = "dog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dog");
        wordList.add("dot");


        PrintUtil.printLn(new Solution().ladderLength(beginWord, endWord, wordList));

    }

    static class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if (!wordList.contains(beginWord)) {
                wordList.add(0, beginWord);
            }

            Map<String, Set<String>> map = generateMap(wordList);
            Queue<String> queue = new LinkedList<>();
            queue.add(beginWord);

            Set<String> visited = new HashSet<>();
            int len = 0;
            while (!queue.isEmpty()) {
                len++;
                Set<String> allNext = new HashSet<>();
                while (!queue.isEmpty()) {
                    String cur = queue.poll();
                    visited.add(cur);

                    Set<String> nexts = map.get(cur);
                    if (nexts != null) {
                        allNext.addAll(nexts);
                    }
                }

                if (allNext.isEmpty()) {
                    return 0;
                }

                if (allNext.contains(endWord)) {
                    return len + 1;
                }

                for (String s : allNext) {
                    if (visited.contains(s)) {
                        continue;
                    }
                    queue.offer(s);
                }
            }

            return 0;
        }

        private Map<String, Set<String>> generateMap(List<String> wordList) {
            int len = wordList.get(0).length() - 1;
            Map<String, Set<String>> map = new HashMap<>();
            for (int i = 0; i < wordList.size(); i++) {
                String cur = wordList.get(i);
                Set<String> nexts = new HashSet<>();
                for (int j = 0; j < wordList.size(); j++) {
                    if (j == i) {
                        continue;
                    }
                    String next = wordList.get(j);
                    if (equalCharCount(cur, next) == len) {
                        nexts.add(next);
                    }
                }

                map.put(cur, nexts);
            }
            return map;
        }

        private int equalCharCount(String s1, String s2) {
            int count = 0;
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) == s2.charAt(i)) {
                    count++;
                }
            }
            return count;
        }
    }

    public class Solution1 {

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            // 第 1 步：先将 wordList 放到哈希表里，便于判断某个单词是否在 wordList 里
            Set<String> wordSet = new HashSet<>(wordList);
            if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
                return 0;
            }

            // 第 2 步：已经访问过的 word 添加到 visited 哈希表里
            Set<String> visited = new HashSet<>();
            visited.add(beginWord);
            visited.add(endWord);
            // 分别用左边和右边扩散的哈希表代替单向 BFS 里的队列，它们在双向 BFS 的过程中交替使用
            Set<String> beginVisited = new HashSet<>();
            beginVisited.add(beginWord);
            Set<String> endVisited = new HashSet<>();
            endVisited.add(endWord);

            // 第 3 步：执行双向 BFS，左右交替扩散的步数之和为所求
            int step = 2;
            while (!beginVisited.isEmpty() && !endVisited.isEmpty()) {
                // 优先选择小的哈希表进行扩散，考虑到的情况更少
                if (beginVisited.size() > endVisited.size()) {
                    Set<String> temp = beginVisited;
                    beginVisited = endVisited;
                    endVisited = temp;
                }

                // 逻辑到这里，保证 beginVisited 是相对较小的集合，nextLevelVisited 在扩散完成以后，会成为新的 beginVisited
                Set<String> nextLevelVisited = new HashSet<>();
                for (String word : beginVisited) {
                    if (changeWordEveryOneLetter(word, endVisited, visited, wordSet, nextLevelVisited)) {
                        return step;
                    }
                }

                // 原来的 beginVisited 废弃，从 nextLevelVisited 开始新的双向 BFS
                beginVisited = nextLevelVisited;
                step++;
            }
            return 0;
        }

        private boolean changeWordEveryOneLetter(String word, Set<String> endVisited,
                                                 Set<String> visited,
                                                 Set<String> wordSet,
                                                 Set<String> nextLevelVisited) {
            char[] charArray = word.toCharArray();
            for (int i = 0; i < word.length(); i++) {
                char originChar = charArray[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (originChar == c) {
                        continue;
                    }
                    charArray[i] = c;
                    String nextWord = String.valueOf(charArray);
                    if (wordSet.contains(nextWord)) {
                        if (endVisited.contains(nextWord)) {
                            return true;
                        }
                        if (!visited.contains(nextWord)) {
                            nextLevelVisited.add(nextWord);
                            visited.add(nextWord);
                        }
                    }
                }
                // 恢复，下次再用
                charArray[i] = originChar;
            }
            return false;
        }
    }
}
