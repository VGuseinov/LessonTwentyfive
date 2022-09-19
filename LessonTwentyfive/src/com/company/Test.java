package com.company;

public class Test {
    private int value;

    public int getValue() {
        return value;
    }

    // будет боликроваться доступ к классу (Test)
    public static synchronized void test() {}

    // блокируется доступ к объекту synchronized()
    public synchronized void inc() {
        this.value++;
    }

    public synchronized void dec() {
        // синхронизация отдельного блока кода внуттри метода,
        // а не метода целиком (блокировка блока кода
        // вместо блокировки объекта целиком)

        // locked / unlocked
        // synchronized (o) => o.state = locked
        // после окончания блока synchronized,
        // этому объекту выставиться состояние unlocked
        synchronized (new Object()) {
            this.value--;
        }
    }
}
