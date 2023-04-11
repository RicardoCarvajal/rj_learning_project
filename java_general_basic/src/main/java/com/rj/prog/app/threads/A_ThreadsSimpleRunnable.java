package com.rj.prog.app.threads;

public class A_ThreadsSimpleRunnable {

    public static void main(String[] args) {

        process process1 = new process(1, "primer proceso", 3000);
        process process2 = new process(2, "primer proceso", 1000);

        Thread t1 = new Thread(process1);
        Thread t2 = new Thread(process2);

        t1.start();
        t2.start();

    }

}

class process implements Runnable {

    private int id;

    private String name;

    private int time;

    public process(int id, String name, int time) {
        this.id = id;
        this.name = name;
        this.time = time;
    }

    public void run() {

        for (int i = 0; i < 3000; i++) {
            System.out.println("ID = " + id + " nombre = " + name + " cuenta = " + i);
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
