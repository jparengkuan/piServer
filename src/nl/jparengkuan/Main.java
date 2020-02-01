package nl.jparengkuan;

public class Main {

    public static void main(String[] args) {
	// write your code here

        MtServer server = new MtServer(7789);
        new Thread(server).start();

    }
}
