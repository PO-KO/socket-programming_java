
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public Server() {
        try {
            ServerSocket server = new ServerSocket(22000);

            // Listen
            System.out.println("Waiting for connection...");
            Socket client = server.accept();
            DataInputStream request = new DataInputStream(client.getInputStream());
            DataOutputStream response = new DataOutputStream(client.getOutputStream());

            String message = "The connection has been established successfully";

            System.out.println(message);
            response.writeUTF(message);
            response.writeUTF("Chat with me (for quit say 'goodby')");
            String clientMessage = request.readUTF();

            while (!clientMessage.equals("goodby")) {
                System.out.println("Client message: " + clientMessage);
            }

            request.close();
            response.close();
            client.close();
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
    }
}
