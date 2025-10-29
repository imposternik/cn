import java.io.*;
import java.net.*;

public class TCPClient {

    public static void main(String[] args) {
        try {
            // Connect to the server running on localhost at port 6789
            Socket socket = new Socket("localhost", 6789);

            // Output to server
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Input from server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Send message to server
            out.println("Hello Server from BKC!");

            // Read server response
            String response = in.readLine();
            System.out.println("Server says: " + response);

            // Close the socket
            socket.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
