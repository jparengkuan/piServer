package nl.jparengkuan;

import java.util.LinkedList;
import java.util.Stack;

public class FileThread implements Runnable {
    private static Stack<LinkedList<String>> buffer=new Stack<>();
    public static void addValue(LinkedList<String> measurement){
        buffer.push(measurement);
    }
   public static LinkedList<String>getValue(){
      return  buffer.pop();
    }


    @Override
    public void run() {
        while(true){
            if(!buffer.isEmpty()) {
                FileWriter.writeData(getValue());
            }
        }
    }
}