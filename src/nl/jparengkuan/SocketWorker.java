package nl.jparengkuan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketWorker implements Runnable {

    protected Socket clientSocket = null;

    public SocketWorker(Socket clientSocket)
    {
        this.clientSocket = clientSocket;
    }


    public void run() {

        String threadName = Thread.currentThread().getName();
        System.out.println("Hello iam " + threadName);

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

                    String stnNumber = buffer.split(">")[2].replace("</STN", "");
                    System.out.println(stnNumber);
                    stnNumber = "";


                }

            }

            in.close(); // Close the stream

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
