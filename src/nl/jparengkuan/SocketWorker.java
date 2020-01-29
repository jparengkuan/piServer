package nl.jparengkuan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class SocketWorker implements Runnable {

    protected Socket clientSocket = null;

    public SocketWorker(Socket clientSocket)
    {
        this.clientSocket = clientSocket;
    }


    public void run() {


        try {

            InputStreamReader streamReader= new InputStreamReader(clientSocket.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);
            DataParser parser = new DataParser();
            boolean record = false;
            HashMap<String, String> values = new HashMap<>();
            ArrayList list = new ArrayList<>();
            FileWriter filewriter = new FileWriter();


            while (!clientSocket.isClosed()) {
                String line = reader.readLine();

                if(line == null) {
                    break;
                } else {
                    if(line.contains("<STN>")) {
                        record = true;
                    }

                    if(line.contains("</MEASUREMENT>")) {
                        parser.processList(list);
                        //System.out.println(parser.getValues());
                        filewriter.writeHandler(parser.getValues());

                        record = false;
                        list.clear();
                        values.clear();
                    }

                    if(record) {
                        list.add(line);
                    }
                }
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
