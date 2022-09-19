package com.company;

import java.util.ArrayList;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
	    // Потоки threads
        // 6577

        long time = System.currentTimeMillis();
//        for (int i = 0; i < 9000000; i++) {
//            double d = Math.sin(Objects.hashCode(i)) * Math.exp(i * i);
//        }



        Thread t1 = new Thread(() -> {
            System.out.println(" В момент запуска: " + Thread.currentThread().getState());
            for (int i = 0; i < 4500000; i++) {
                double d = Math.sin(Objects.hashCode(i)) * Math.exp(i * i);
            }
        });


        Thread t2 = new Thread(() -> {
            for (int i = 4500000; i < 9000000; i++) {
                double d = Math.sin(Objects.hashCode(i)) * Math.exp(i * i);
            }
        });

        System.out.println(" Перед запуском: " + t1.getState());

        // запуск потоков на выполнение
        t1.start();
        t2.start();

        System.out.println(" После запуска: " + t1.getState());
        try {
            // ожидаем завершения дочерних потоков
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(" Полсле завершения: " + t1.getState());

        System.out.println(System.currentTimeMillis() - time);


    }
}
