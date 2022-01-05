package com.ricardo.hilos;

import java.io.Serializable;

public class TaskBean implements Runnable, Serializable {

    private int counter;

    private int sum;

    private boolean started;

    private boolean running;

    private int sleep;

    public TaskBean() {
        this.counter = 0;
        this.sum = 0;
        this.started = false;
        this.running = false;
        this.sleep = 100;
    }

    @Override
    public void run() {
        try {
            setRunning(true);
            while (isRunning() && !isCompleted())
                work();
        } finally {
            setRunning(false);
        }

    }

    protected void work() {
        try {
            Thread.sleep(sleep);
            counter++;
            sum += counter;
        } catch (InterruptedException e) {
            setRunning(false);
        }
    }

    public synchronized int getPercent() {
        return counter;
    }

    public synchronized boolean isStarted() {
        return started;
    }

    public synchronized boolean isCompleted() {
        return counter == 100;
    }

    public synchronized boolean isRunning() {
        return running;
    }

    public synchronized void setRunning(boolean running) {
        this.running = running;
        if (running)
            started = true;
    }

    public synchronized Object getResult() {
        if (isCompleted())
            return new Integer(sum);
        else
            return null;
    }

}
