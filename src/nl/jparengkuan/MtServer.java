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
    protected ScheduledExecutorService executor;

    protected int delay = 0;


    public MtServer(int port) {
        this.serverPort = port;
        this.executor = Executors.newScheduledThreadPool(800);
    }

    @Override
    public void run() {

        //Open een nieuwe serverSocket
        openServerSocket();
        while(true){
        Socket clientSocket = null;


        // Try accepting the incoming connection
        // Else throw a runtime error
        try {
            clientSocket = this.serverSocket.accept();
        } catch (IOException e) {
            throw new RuntimeException("Cannot open accept the connection: ", e);
        }

        //Create a new scheduled task
        executor.schedule(new SocketWorker(clientSocket), this.delay, TimeUnit.MILLISECONDS);

        //Increase the delay
        this.delay += 200;
     }

    }


    private void openServerSocket() {
        try {
            this.serverSocket = new ServerSocket(this.serverPort);
        } catch (IOException e) {
            throw new RuntimeException("Cannot open ServerSocket on port: " + this.serverPort, e);
        }
    }
}
