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
        for(int i=0;i<=13;i++){
            if(data.get(i).equals("")) {
                switch(i){
                    case 0:
                        data.set(0,"1111111");
                        break;
                    case 1:
                        data.set(1,"1111-11-11");
                        break;
                    case 2:
                        data.set(2,"11:11:11");
                        break;
                    case 3:
                        data.set(3,"111");
                        break;
                    case 4:
                        data.set(4,"11");
                        break;
                    case 5:
                        data.set(5,"-1111");
                        break;
                    case 6:
                        data.set(6,"-1111");
                        break;
                    case 7:
                        data.set(7,"-1111");
                        break;
                    case 8:
                        data.set(8,"111");
                        break;
                    case 9:
                        data.set(9,"111");
                        break;
                    case 10:
                        data.set(10,"111");
                        break;
                    case 11:
                        data.set(11,"000000");
                        break;
                    case 12:
                        data.set(12,"111");
                        break;
                    case 13:
                        data.set(13,"361");
                        break;

                }
            }
        }



        return data;
    }


}
