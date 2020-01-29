package nl.jparengkuan;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.LinkedList;

public class FileWriter {
    static HashMap<String,FileOutputStream> open_streams;
    public static FileOutputStream  OpenFile(File file,String path){
        FileOutputStream writer=null;
        try {



            if (!file.exists()) {
                file.createNewFile();



            }
            writer = new FileOutputStream(path, true);
            open_streams.put(path,writer);

        }catch(IOException e){
            e.printStackTrace();
        }


        return writer;

    }




    public static void writeData(LinkedList<String> weatherData) {
        try {
            Path currentDir = FileSystems.getDefault().getPath("");

            String path = currentDir + weatherData.get(2) + ".csv";

            File file = new File(path);
            FileOutputStream writer=OpenFile(file,path);


            writer.write((weatherData.get(0)+","+weatherData.get(1)+","+weatherData.get(2)
                    +","+weatherData.get(3)+","+weatherData.get(4)+","+weatherData.get(5)
                    +","+weatherData.get(6)+","+weatherData.get(7)+","+weatherData.get(8)
                    +","+weatherData.get(9)+","+weatherData.get(10)+","+weatherData.get(11)+
                    ","+weatherData.get(12)+","+weatherData.get(13)+"\r\n").getBytes() );


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String [] args){
        FileWriter.writeData(new LinkedList<>());
    }
}