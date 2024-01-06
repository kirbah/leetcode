/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 */

// @lc code=start

import java.util.Stack;

class MinStack {
    private Stack<Integer> store = new Stack<>();
    private Stack<Integer> minStore = new Stack<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        store.push(val);
        int min = minStore.isEmpty() ? val : Math.min(minStore.peek(), val);
        minStore.push(min);
    }
    
    public void pop() {
        store.pop();
        minStore.pop();
    }
    
    public int top() {
        return store.peek();
    }
    
    public int getMin() {
        return minStore.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

