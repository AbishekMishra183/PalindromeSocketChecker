package Test.com;
import java.net.*;
import java.io.*;
import java.util.*;


public class ClientSide {
    public static void main(String[] args) throws IOException {
        try (Scanner userInputScanner = new Scanner(System.in)){
            Socket socket = new Socket("localhost", 8080);
            Scanner ins = new Scanner(socket.getInputStream());
            PrintWriter outs = new PrintWriter(socket.getOutputStream(), true);
System.out.println("please enter the number you want to check Palindrome");
            int userNumber = userInputScanner.nextInt();

            outs.println( userNumber);
            String Value = ins.nextLine();
            System.out.println("Pathako NUmber" +  userNumber);
            System.out.println("Palindromme check from server\t"      + Value);
            ins.close();
            outs.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}