package nl.jparengkuan;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MtServer implements Runnable {

    protected int serverPort;
    protected ServerSocket serverSocket = null;
    protected boolean isStopped = false;
    protected Thread runningThread = null;


    public MtServer(int port) {
        this.serverPort = port;
    }

    @Override
    public void run() {
        // synchronize the action of multiple threads and make sure that only one thread
        // can access the resource at a given point in time
        synchronized (this) {
            this.runningThread = Thread.currentThread();
        }

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

            System.out.println(1);

            SocketWorker worker = new SocketWorker(clientSocket);
            new Thread(worker).start();


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
