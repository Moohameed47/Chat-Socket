package client;

import java.io.DataOutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try {
            Socket s = new Socket("127.0.0.1", 1234);   // localhost --> 127.0.0.1
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            dout.writeUTF("Hello,Labtop Server");
            dout.flush();
            dout.close();
            s.close();
        } catch (Exception e) {
        }
    }
}
