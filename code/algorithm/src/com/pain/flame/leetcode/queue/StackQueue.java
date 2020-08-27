package com.pain.flame.leetcode.queue;

import java.util.Stack;

/**
 * https://leetcode.com/problems/implement-queue-using-stacks/
 * 232. Implement Queue using Stacks
 */
public class StackQueue {

    private Stack<Integer> input;
    private Stack<Integer> output;

    public StackQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }

        return output.pop();
    }

    public int peek() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }

        return output.peek();
     }

    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}
