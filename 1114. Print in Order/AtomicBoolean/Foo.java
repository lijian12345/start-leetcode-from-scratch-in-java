import java.util.concurrent.atomic.AtomicBoolean;

class Foo {
    private AtomicBoolean isFirstDone = new AtomicBoolean();
    private AtomicBoolean isSecondDone = new AtomicBoolean();

    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        isFirstDone.set(true);
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (!isFirstDone.get()) {
        }
        printSecond.run();
        isSecondDone.set(true);
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (!isSecondDone.get()) {
        }
        printThird.run();
    }
}
