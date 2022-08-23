package server;
import java.io.DataInput;
import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        System.out.println("Server Is Running\n");
        try {
            ServerSocket ss = new ServerSocket(1234);
            Socket s = ss.accept();
            DataInputStream dis = new DataInputStream(s.getInputStream());
            String str = (String) dis.readUTF();
            System.out.println("Client Says: " + str);
            ss.close();
        } catch (Exception e) {
        }

    }

}
