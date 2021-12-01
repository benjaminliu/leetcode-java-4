package com.ben.template.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class _0752_Open_the_Lock {

    public static class Solution1 {
        public int openLock(String[] deadends, String target) {
            Set<String> deadSet = new HashSet<>();
            for (String s : deadends) {
                deadSet.add(s);
            }
            Set<String> visited = new HashSet<>();
            Queue<String> queue = new LinkedList<>();
            queue.add("0000");
            visited.add("0000");
            int step = 0;

            while (!queue.isEmpty()) {
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    String cur = queue.poll();
                    //Meet a deadend, ignore
                    if (deadSet.contains(cur)) {
                        continue;
                    }

                    //Find the target, return step (BFS, so this is the min step)
                    if (cur.equals(target)) {
                        return step;
                    }

                    //Each turn, we can move 1 of four circular wheels
                    //Either plus 1, or minus 1
                    for (int j = 0; j < 4; j++) {
                        String up = plusOne(cur, j);
                        if (!visited.contains(up)) {
                            visited.add(up);
                            queue.offer(up);
                        }

                        String down = minusOne(cur, j);
                        if (!visited.contains(down)) {
                            visited.add(down);
                            queue.offer(down);
                        }
                    }
                }

                step++;
            }
            return -1;
        }

        private String minusOne(String s, int wheelIdx) {
            char[] ch = s.toCharArray();
            if (ch[wheelIdx] == '9') {
                ch[wheelIdx] = '0';
            } else {
                ch[wheelIdx]++;
            }
            return new String(ch);
        }

        private String plusOne(String s, int wheelIdx) {
            char[] ch = s.toCharArray();
            if (ch[wheelIdx] == '0') {
                ch[wheelIdx] = '9';
            } else {
                ch[wheelIdx]--;
            }
            return new String(ch);
        }
    }

    //Bi-direction BFS
    public static class Solution2 {
        public int openLock(String[] deadends, String target) {
            Set<String> deadSet = new HashSet<>();
            for (String s : deadends) {
                deadSet.add(s);
            }
            Set<String> visited = new HashSet<>();

            Set<String> forward = new HashSet<>();
            Set<String> backward = new HashSet<>();

            int step = 0;
            forward.add("0000");
            backward.add(target);

            while (!forward.isEmpty() && !backward.isEmpty()) {
                //Always move the one with less nodes
                if (forward.size() > backward.size()) {
                    Set<String> temp = forward;
                    forward = backward;
                    backward = temp;
                }

                Set<String> temp = new HashSet<>();
                for (String cur : forward) {
                    if (deadSet.contains(cur)) {
                        continue;
                    }
                    //forward meet backward, we find a path
                    if (backward.contains(cur)) {
                        return step;
                    }
                    visited.add(cur);

                    for (int i = 0; i < 4; i++) {
                        String up = plusOne(cur, i);
                        if (!visited.contains(up)) {
                            temp.add(up);
                        }
                        String down = minusOne(cur, i);
                        if (!visited.contains(down)) {
                            temp.add(down);
                        }
                    }
                }
                step++;
                // 1 side moved 1 step, now we let the other side move
                forward = backward;
                backward = temp;
            }

            return -1;
        }

        private String minusOne(String s, int wheelIdx) {
            char[] ch = s.toCharArray();
            if (ch[wheelIdx] == '9') {
                ch[wheelIdx] = '0';
            } else {
                ch[wheelIdx]++;
            }
            return new String(ch);
        }

        private String plusOne(String s, int wheelIdx) {
            char[] ch = s.toCharArray();
            if (ch[wheelIdx] == '0') {
                ch[wheelIdx] = '9';
            } else {
                ch[wheelIdx]--;
            }
            return new String(ch);
        }
    }
}
