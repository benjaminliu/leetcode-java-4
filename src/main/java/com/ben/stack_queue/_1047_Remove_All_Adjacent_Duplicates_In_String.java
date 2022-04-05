package com.ben.stack_queue;

import java.util.Deque;
import java.util.LinkedList;

public class _1047_Remove_All_Adjacent_Duplicates_In_String {

    class Solution {
        public String removeDuplicates(String s) {
            if (s.length() < 2) {
                return s;
            }

            Deque<Character> deque = new LinkedList<>();
            for (char c : s.toCharArray()) {
                if (!deque.isEmpty()) {
                    if (c == deque.getLast()) {
                        deque.removeLast();
                        continue;
                    }
                }

                deque.addLast(c);
            }

            StringBuilder sb = new StringBuilder();
            while (!deque.isEmpty()) {
                sb.append(deque.removeFirst());
            }

            return sb.toString();
        }
    }
}
