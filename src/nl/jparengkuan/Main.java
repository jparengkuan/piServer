package nl.jparengkuan;

public class Main {

    public static void main(String[] args) {

        //create server with  server socket
        MtServer server = new MtServer(7789);
        new Thread(server).start();

    }
}
