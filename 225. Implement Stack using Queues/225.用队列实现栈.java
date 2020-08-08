/*
 * @lc app=leetcode.cn id=225 lang=java
 *
 * [225] 用队列实现栈
 */

// @lc code=start
class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;
    int top;

    /** Initialize your data structure here. */
    public MyStack() {
        this.q1 = new LinkedList<>();
        this.q2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if (q1.isEmpty()) {
            q2.offer(x);
        } else {
            q1.offer(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (q1.isEmpty()) {
            while (q2.size() > 1) {
                q1.offer(q2.poll());
            }
            return q2.poll();
        } else {
            while (q1.size() > 1) {
                q2.offer(q1.poll());
            }
            return q1.poll();
        }
    }

    /** Get the top element. */
    public int top() {
        int top = 0;
        if (q1.isEmpty()) {
            while (q2.size() > 1) {
                q1.offer(q2.poll());
            }
            top = q2.poll();
            q1.offer(top);
        } else {
            while (q1.size() > 1) {
                q2.offer(q1.poll());
            }
            top = q1.poll();
            q2.offer(top);
        }
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

