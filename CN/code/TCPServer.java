import java.io.*;
import java.net.*;

public class TCPServer {

    public static void main(String[] args) {
        try {
            // Create a server socket listening on port 6789
            ServerSocket serverSocket = new ServerSocket(6789);
            System.out.println("Server is waiting for client connection...");

            // Accept client connection
            Socket socket = serverSocket.accept();
            System.out.println("Connected to: " + socket.getInetAddress());

            // Input from client
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Output to client
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Read message from client
            String clientMessage = in.readLine();
            System.out.println("Client Staff says from BKC: " + clientMessage);

            // Send reply to client
            out.println("Hello Client Staff from BKC, message received!");

            // Close sockets
            socket.close();
            serverSocket.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
