package nl.jparengkuan;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MtServer implements Runnable {

    protected int serverPort;
    protected ServerSocket serverSocket = null;
    protected boolean isStopped = false;
    protected Thread runningThread = null;
    protected ScheduledExecutorService executor;

    protected int delay = 0;


    public MtServer(int port) {

        this.serverPort = port;

        this.executor = Executors.newScheduledThreadPool(1000);
    }

    @Override
    public void run() {
        // synchronize the action of multiple threads and make sure that only one thread
        // can access the resource at a given point in time


        openServerSocket();

        while (!isStopped()) {
            Socket clientSocket = null;
            try {

                clientSocket = this.serverSocket.accept();

            } catch (IOException e) {
                if (isStopped()) {
                    System.out.println("Server stopped!");
                    return;
                }

                throw new RuntimeException("Error accepting client connection!", e);
            }



            executor.schedule(new SocketWorker(clientSocket), this.delay , TimeUnit.MILLISECONDS);

            this.delay += 150;


            //SocketWorker worker = new SocketWorker(clientSocket);
            //new Thread(worker).start();



        }


    }

    private synchronized boolean isStopped() {
        return this.isStopped;
    }


    private void openServerSocket() {
        try {
            this.serverSocket = new ServerSocket(this.serverPort);
        } catch (IOException e) {
            throw new RuntimeException("Cannot open ServerSocket on port: " + this.serverPort, e);
        }
    }
}
