package com.pain.flame.leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 * 20. Valid Parentheses
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);

            if (!map.keySet().contains(c)) {
                stack.push(c);
            } else if (stack.isEmpty() || map.get(c) != stack.pop()) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
