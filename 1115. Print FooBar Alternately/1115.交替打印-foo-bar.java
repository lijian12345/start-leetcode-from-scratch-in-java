/*
 * @lc app=leetcode.cn id=1115 lang=java
 *
 * [1115] 交替打印FooBar
 */

// @lc code=start
class FooBar {
    private int n;
    private boolean isFoo = true;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (this) {
                if (isFoo == false) {
                    wait();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                isFoo = false;
                notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (this) {
                if (isFoo == true) {
                    wait();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                isFoo = true;
                notifyAll();
            }
        }
    }
}

// @lc code=end

