package nl.jparengkuan;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.LinkedList;

public class FileWriter {
    static HashMap<String,FileOutputStream> open_streams=new HashMap<>();
    public static FileOutputStream  OpenFile(String path,String name){
        File file=new File(path);
        FileOutputStream stream=null;

        try {
            //create file if it doesn't exist yet
            if (!file.exists()) {
                file.createNewFile();
            }

            //check if file is already open and get the stream
            if(open_streams.containsKey(name)){
                stream=open_streams.get(name);
            }else {
                //if not: open file and add it to open file list
                stream = new FileOutputStream(path, true);
                open_streams.put(name,stream);
            }




        } catch (IOException e) {
            e.printStackTrace();
        }

        return stream;

    }




    public static void writeData(LinkedList<String> weatherData) {
        try {
            Path currentDir = FileSystems.getDefault().getPath("");
            String station_name=weatherData.get(0);
            String path = currentDir + station_name + ".csv";


            FileOutputStream writer=OpenFile(path,station_name);


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
        LinkedList<String> weatherData=new LinkedList<>();
        weatherData.add("1");
        weatherData.add("1");
        weatherData.add("1");
        weatherData.add("1");
        weatherData.add("1");
        weatherData.add("1");
        weatherData.add("1");
        weatherData.add("1");
        weatherData.add("1");
        weatherData.add("1");
        weatherData.add("1");
        weatherData.add("1");
        weatherData.add("1");
        weatherData.add("1");
        FileWriter.writeData(weatherData);
    }
}