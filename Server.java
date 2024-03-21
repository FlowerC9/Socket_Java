import java.net.*;
import java.io.*;
public class Server {
    private Socket socket=null;
    private ServerSocket server=null;
    private BufferedReader in =null;
    public Server(int port){
        try {
            server=new ServerSocket(port);
            System.out.println("Server Started");
            System.out.println("Wating For a client");
            socket=server.accept();
            System.out.println("Client accepted");
            in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line="";
            while(!line.equals("Over")){
                try {
                    line=in.readLine();
                    System.out.println(line);
                } catch (IOException i) {
                    System.out.println(i);
                }
            }
            System.out.println("Closing connection");
            socket.close();
            in.close();
        } catch (IOException i) {
           System.out.println(i);
        }
    }
    public static void main(String[] args) {
        Server server=new Server(5000);
    }
}
