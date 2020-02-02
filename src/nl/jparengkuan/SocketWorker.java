package nl.jparengkuan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

/**
 * This class handles an individual socket
 */
public class SocketWorker implements Runnable {

    protected Socket clientSocket = null;

    public SocketWorker(Socket clientSocket)
    {
        this.clientSocket = clientSocket;
    }

    /**
     * This method runs a thread that reads a socket's data, calls the Dataparser.Dataparser function
     * to parse the data and then calls the Filewriter.writeData function to write the parsed data to a file.
     */
    public void run() {



        // String threadName = Thread.currentThread().getName();
       // System.out.println("Hello iam " + threadName);

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));

            String input;
            String buffer = "";

            while ((input = in.readLine()) != null){
                if (input.equals("\t<MEASUREMENT>")) {
                    buffer = "";
                }

                buffer = buffer + input;

                if (input.equals("\t</MEASUREMENT>")) {

                 LinkedList<String> data=DataParser.DataParser(buffer);

                    FileWriter.writeData(data);
                }

                }

            //in.close(); // Close the stream

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
