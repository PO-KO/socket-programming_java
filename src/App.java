
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class App {

    public App() {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            Socket server = new Socket(ip, 22000);

            DataInputStream serverRead = new DataInputStream(server.getInputStream());
            DataOutputStream serverWrite = new DataOutputStream(server.getOutputStream());

            boolean isEmpty = true;
            while (!isEmpty) {
                String str = serverRead.readUTF();
                System.out.println(str);

            }

            Scanner clientInput = new Scanner(System.in);
            while (!clientInput.nextLine().equals("goodby")) {

                String message = clientInput.nextLine();
                System.out.print("write : " + message);
                serverWrite.writeUTF(message);
            }

            clientInput.close();
            serverWrite.close();
            serverRead.close();
            server.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        App client = new App();
    }

}
