import java.io.*;
import java.net.*;

public class Client {
    private Socket socket = null;
    private BufferedReader input = null;
    private PrintWriter out = null;

    public Client(String address, int port) {
        try {
            socket = new Socket(address, port);
            System.out.println("connected");
            input = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(socket.getOutputStream(), true); // 'true' enables autoflush
        } catch (UnknownHostException u) {
            System.out.println(u);
            return;
        } catch (IOException i) {
            System.out.println(i);
            return;
        }
        String line = "";
        while (!line.equals("Over")) {
            try {
                line = input.readLine();
                out.println(line);
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        try {
            input.close();
            out.close();
            socket.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        Client client=new Client("127.0.0.1", 5000);
    }
}
