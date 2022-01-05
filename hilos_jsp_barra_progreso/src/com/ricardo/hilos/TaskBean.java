package com.ricardo.hilos;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class TaskBean implements Runnable, Serializable {

    private boolean started;

    private boolean running;

    private int sleep;

    private String consola;

    private String linealUltima;

    private Session session;

    public TaskBean() {
        this.consola = " ";
        this.started = false;
        this.running = false;
        this.sleep = 100;
        this.linealUltima = " ";
    }

    @Override
    public void run() {
        try {
            setRunning(true);
            while (isRunning()) {
                work();
            }
        } finally {
            setRunning(false);
        }

    }

    protected void work() {
        try {

            Thread.sleep(sleep);

            if (session == null || !session.isConnected()) {

                JSch jsch = new JSch();

                session = jsch.getSession("cajero", "10.1.10.212");

                session.setPassword("cajero");

                session.setConfig("StrictHostKeyChecking", "no");

                session.setTimeout(3000);

                session.connect();

                ChannelExec chasnnelExec = (ChannelExec) session.openChannel("exec");

                InputStream in = chasnnelExec.getInputStream();

                chasnnelExec.setCommand("tail -19 /opt/CR/logs/Log.2017-11-30.09:49:43.log");

                chasnnelExec.connect();

                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                String linea = null;

                String lineal = " ";

                String bloque = " ";

                while ((linea = reader.readLine()) != null) {

                    lineal = lineal + linea;

                    if (!linealUltima.equalsIgnoreCase(lineal)) {

                        bloque = bloque + "\n" + linea;

                    }

                    consola = bloque;

                }

                linealUltima = lineal;

                chasnnelExec.disconnect();

                session.disconnect();

            } else {

                throw new IllegalAccessException("Sesion SSH ya iniciada.");

            }

        } catch (Exception e) {
            setRunning(false);
        }
    }

    public synchronized String getConsola() {
        return consola;
    }

    public synchronized void getClearConsola() {
        consola = " ";
    }

    public synchronized boolean isStarted() {
        return started;
    }

    public synchronized boolean isRunning() {
        return running;
    }

    public synchronized void setRunning(boolean running) {
        this.running = running;
        if (running)
            started = true;
    }

}
