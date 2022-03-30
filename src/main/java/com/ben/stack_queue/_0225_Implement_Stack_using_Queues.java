package com.ben.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class _0225_Implement_Stack_using_Queues {

    class MyStack {

        private Queue<Integer> main = new LinkedList<>();
        private Queue<Integer> backup = new LinkedList<>();

        public MyStack() {

        }

        public void push(int x) {
            main.offer(x);
        }

        public int pop() {
            backup();

            int res = main.poll();

            restore();
            return res;
        }

        public int top() {
            backup();

            int res = main.poll();

            restore();
            main.offer(res);

            return res;
        }

        public boolean empty() {
            return main.isEmpty() && backup.isEmpty();
        }

        private void backup() {
            while (main.size() > 1) {
                backup.offer(main.poll());
            }
        }

        private void restore() {
            while (!backup.isEmpty()) {
                main.offer(backup.poll());
            }
        }
    }

    class MyStack1 {
        Queue<Integer> queue;

        public MyStack1() {
            this.queue = new LinkedList<Integer>();
        }

        // Push element x onto stack.
        public void push(int x) {
            queue.add(x);
            for (int i = 0; i < queue.size() - 1; i++) {
                queue.add(queue.poll());
            }
        }

        // Removes the element on top of the stack.
        public void pop() {
            queue.poll();
        }

        // Get the top element.
        public int top() {
            return queue.peek();
        }

        // Return whether the stack is empty.
        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
