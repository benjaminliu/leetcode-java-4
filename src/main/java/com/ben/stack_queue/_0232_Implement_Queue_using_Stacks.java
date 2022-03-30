package com.ben.stack_queue;

import java.util.Stack;

public class _0232_Implement_Queue_using_Stacks {

    class MyQueue {
        Stack<Integer> input = new Stack();
        Stack<Integer> output = new Stack();

        public MyQueue() {
        }

        public void push(int x) {
            input.push(x);
        }

        public int pop() {
            moveInputToOutput();

            return output.pop();
        }

        private void moveInputToOutput() {
            if (output.isEmpty()) {
                while (!input.isEmpty()) {
                    output.push(input.pop());
                }
            }
        }

        public int peek() {
            moveInputToOutput();
            return output.peek();
        }

        public boolean empty() {
            return input.isEmpty() && output.isEmpty();
        }
    }
}
