package nl.jparengkuan;

import java.util.LinkedList;

public class DataParser {

    public static LinkedList<String> DataParser(String buffer)
    {
        LinkedList<String> data = new LinkedList<String>();

        String[] test = buffer.split(">");

        data.add(test[2].replace("</STN", ""));
        data.add(test[4].replace("</DATE", ""));
        data.add(test[6].replace("</TIME", ""));
        data.add(test[8].replace("</TEMP", ""));
        data.add(test[10].replace("</DEWP", ""));
        data.add(test[12].replace("</STP", ""));
        data.add(test[14].replace("</SLP", ""));
        data.add(test[16].replace("</VISIB", ""));
        data.add(test[18].replace("</WDSP", ""));
        data.add(test[20].replace("</PRCP", ""));
        data.add(test[22].replace("</SNDP", ""));
        data.add(test[24].replace("</FRSHTT", ""));
        data.add(test[26].replace("</CLDC", ""));
        data.add(test[28].replace("</WNDDIR", ""));


        return data;
    }


}
