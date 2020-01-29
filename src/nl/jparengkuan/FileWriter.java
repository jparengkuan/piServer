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

            String path = currentDir + (String) weatherData.get(2) + ".csv";

            File file = new File(path);
            FileOutputStream writer=OpenFile(file,path);


            writer.write((weatherData.get(2)+","+weatherData.get(4)+","+weatherData.get(6)
                    +","+weatherData.get(8)+","+weatherData.get(10)+","+weatherData.get(12)
                    +","+weatherData.get(14)+","+weatherData.get(16)+","+weatherData.get(18)
                    +","+weatherData.get(20)+","+weatherData.get(22)+","+weatherData.get(24)+
                    ","+weatherData.get(26)+","+weatherData.get(28)+"\r\n").getBytes() );


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}