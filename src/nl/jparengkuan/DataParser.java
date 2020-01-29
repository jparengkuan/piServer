package nl.jparengkuan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class DataParser {

    public HashMap<String, String> values;

    public DataParser() {
        this.values = new HashMap<>();
    }

    public LinkedList<String> DataParser(String buffer)
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

    public void processList(ArrayList list) {

        this.values.clear();

        for(int i = 0; i < list.size(); i++) {
            String s = list.get(i).toString();

            //System.out.println(s);
            if(s.contains("STN")) {
                String temp = s;
                temp = temp.substring(temp.indexOf(">") + 1);
                temp = temp.substring(0, temp.indexOf("<"));
                this.values.put("Station", temp);
            }

            if(s.contains("DATE")) {
                String temp = s;
                temp = temp.substring(temp.indexOf(">") + 1);
                temp = temp.substring(0, temp.indexOf("<"));
                this.values.put("Date", temp);
            }

            if(s.contains("TIME")) {
                String temp = s;
                temp = temp.substring(temp.indexOf(">") + 1);
                temp = temp.substring(0, temp.indexOf("<"));
                this.values.put("Time", temp);
            }

            if(s.contains("TEMP")) {
                String temp = s;
                temp = temp.substring(temp.indexOf(">") + 1);
                temp = temp.substring(0, temp.indexOf("<"));
                this.values.put("Temperature", temp);
            }

            if(s.contains("DEWP")) {
                String temp = s;
                temp = temp.substring(temp.indexOf(">") + 1);
                temp = temp.substring(0, temp.indexOf("<"));
                this.values.put("Dew", temp);
            }

            if(s.contains("STP")) {
                String temp = s;
                temp = temp.substring(temp.indexOf(">") + 1);
                temp = temp.substring(0, temp.indexOf("<"));
                this.values.put("Air Pressure Station", temp);
            }

            if(s.contains("SLP")) {
                String temp = s;
                temp = temp.substring(temp.indexOf(">") + 1);
                temp = temp.substring(0, temp.indexOf("<"));
                this.values.put("Air Pressure Sea", temp);
            }

            if(s.contains("VISIB")) {
                String temp = s;
                temp = temp.substring(temp.indexOf(">") + 1);
                temp = temp.substring(0, temp.indexOf("<"));
                this.values.put("Visibility", temp);
            }

            if(s.contains("WDSP")) {
                String temp = s;
                temp = temp.substring(temp.indexOf(">") + 1);
                temp = temp.substring(0, temp.indexOf("<"));
                this.values.put("Wind Speed", temp);
            }

            if(s.contains("PRCP")) {
                String temp = s;
                temp = temp.substring(temp.indexOf(">") + 1);
                temp = temp.substring(0, temp.indexOf("<"));
                this.values.put("Precipitation", temp);
            }

            if(s.contains("SNDP")) {
                String temp = s;
                temp = temp.substring(temp.indexOf(">") + 1);
                temp = temp.substring(0, temp.indexOf("<"));
                this.values.put("Snow", temp);
            }

            if(s.contains("FRSHTT")) {
                String temp = s;
                temp = temp.substring(temp.indexOf(">") + 1);
                temp = temp.substring(0, temp.indexOf("<"));
                this.values.put("Events", temp);
            }

            if(s.contains("CLDC")) {
                String temp = s;
                temp = temp.substring(temp.indexOf(">") + 1);
                temp = temp.substring(0, temp.indexOf("<"));
                this.values.put("Clouds", temp);
            }

            if(s.contains("WNDDIR")) {
                String temp = s;
                temp = temp.substring(temp.indexOf(">") + 1);
                temp = temp.substring(0, temp.indexOf("<"));
                this.values.put("Wind Direction", temp);
            }
        }

    }

    public HashMap<String, String> getValues() {
        return values;
    }


}
