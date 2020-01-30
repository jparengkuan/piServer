package nl.jparengkuan;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.LinkedList;

public class FileWriter {
    public static byte get_remainder(String []array){
        byte remainder=0;
        if(array.length==2) {
            return Byte.valueOf(array[1]);

        }
            return  remainder;

        }



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
            String path = currentDir + station_name + ".bin";


            FileOutputStream writer=OpenFile(path,station_name);
            String [] date=weatherData.get(1).split("-");
            short year=Short.valueOf(date[0]);
            byte month=Byte.valueOf(date[1]);
            byte day=Byte.valueOf(date[2]);
            String [] time=weatherData.get(2).split(":");
            byte hours=Byte.valueOf(time[0]);
            byte minutes=Byte.valueOf(time[1]);
            byte seconds=Byte.valueOf(time[2]);
            String [] temp_array=weatherData.get(3).split("\\.");
            byte temp=Byte.valueOf(temp_array[0]);
            byte temp_remainder=get_remainder(temp_array);

            String [] dewp_array=weatherData.get(4).split("\\.");
            byte dewp=Byte.valueOf(dewp_array[0]);
            byte dewp_remainder=get_remainder(dewp_array);
            String [] stp_array=weatherData.get(5).split("\\.");
            short stp=Short.valueOf(stp_array[0]);
            byte stp_remainder=get_remainder(stp_array);
            String [] slp_array=weatherData.get(6).split("\\.");
            short slp=Short.valueOf(slp_array[0]);
            byte slp_remainder=get_remainder(slp_array);
            String [] visib_array=weatherData.get(7).split("\\.");
            short visib=Short.valueOf(visib_array[0]);
            byte visib_remainder=get_remainder(visib_array);
            String [] wdsp_array=weatherData.get(8).split("\\.");
            byte wdsp=Byte.valueOf(wdsp_array[0]);
            byte wdsp_remainder=get_remainder(wdsp_array);
            String [] prcp_array=weatherData.get(9).split("\\.");
            byte prcp=Byte.valueOf(prcp_array[0]);
            byte prcp_remainder=get_remainder(prcp_array);
            String [] sndp_array=weatherData.get(10).split("\\.");
            byte sndp=Byte.valueOf(sndp_array[0]);
            byte sndp_remainder=get_remainder(sndp_array);
            byte frshtt=0;
            for (int i=0;i<6;i++){
                char c=weatherData.get(11).charAt(i);
                frshtt+=Byte.parseByte(String.valueOf(c));
            }

            String [] cldc_array=weatherData.get(12).split("\\.");
            byte cldc=Byte.valueOf(cldc_array[0]);
            byte cldc_remainder=get_remainder(cldc_array);
            short wnddir=Short.valueOf(weatherData.get(13));
            byte [] bytes={
                    (byte) year,
                    (byte)(year >>8),
                    month,
                    day,
                    hours,
                    minutes,
                    seconds,
                    temp,
                    temp_remainder,
                    dewp,
                    dewp_remainder,
                    (byte) stp,
                    (byte)(stp >>8),
                    stp_remainder,
                    (byte) slp,
                    (byte)(slp >>8),
                    slp_remainder,
                    (byte) visib,
                    (byte)(visib >>8),
                    visib_remainder,
                    wdsp,
                    wdsp_remainder,
                    prcp,
                    prcp_remainder,
                    sndp,
                    sndp_remainder,
                    frshtt,
                    cldc,
                    cldc_remainder,
                    (byte) wnddir,
                    (byte)(wnddir >>8),
            };
            writer.write(bytes);



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}