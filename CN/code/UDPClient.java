import java.net.*;
import java.util.Scanner;
public class UDPClient {
 public static void main(String[] args) {
 try {
 DatagramSocket clientSocket = new DatagramSocket();
 InetAddress IPAddress = InetAddress.getByName("localhost");
 byte[] sendData;
 byte[] receiveData = new byte[1024];
 Scanner sc = new Scanner(System.in);
 System.out.print("Enter message: ");
 String message = sc.nextLine();
 sendData = message.getBytes();
 DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,
IPAddress, 9876);
 clientSocket.send(sendPacket);
 DatagramPacket receivePacket = new DatagramPacket(receiveData,
receiveData.length);
 clientSocket.receive(receivePacket);
String serverResponse = new String(receivePacket.getData(), 0,
receivePacket.getLength());
 System.out.println("Server reply: " + serverResponse);
 clientSocket.close();
 } catch (Exception e) {
 System.out.println(e);
 }
 }
}