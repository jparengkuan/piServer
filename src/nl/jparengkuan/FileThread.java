package nl.jparengkuan;

import java.util.LinkedList;

public class FileThread implements Runnable {
   private LinkedList<String> data;
    public FileThread(LinkedList<String> data){
        this.data=data;
    }
    @Override
    public void run() {
        FileWriter.writeData(data);
    }
}
