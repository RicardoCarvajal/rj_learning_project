package com.rj.prog.app.threads;

import javax.swing.JOptionPane;

public class B_ThreadsSimpleRunnableInterrupted {

    public static void main(String[] args) {

        Process process1 = new Process(1, "primer proceso");
        Thread t1 = new Thread(process1);
        t1.start();

        WindowsProcess process2 = new WindowsProcess(t1);
        Thread t2 = new Thread(process2);
        t2.start();

    }
}

class WindowsProcess implements Runnable {

    private Thread thread;

    public WindowsProcess(Thread thread) {
        this.thread = thread;
    }

    public void run() {
        int response = JOptionPane.showConfirmDialog(null, "¿Interrumpir?");
        if (response == 0) {
            thread.interrupt();
            System.out.println("Hilo interrumpido");
            System.out.println("Estado del hilo interrumpido: " + thread.isInterrupted());
        }
    }

}

class Process implements Runnable {

    private int id;

    private String name;

    public Process(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void run() {

        int i = 0;
        while (!Thread.currentThread().isInterrupted()) {
            ++i;
            System.out.println("ID = " + id + " nombre = " + name + " cuenta = " + i);
        }

    }

}
