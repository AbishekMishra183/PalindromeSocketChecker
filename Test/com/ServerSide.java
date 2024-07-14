import java.io.*;
import java.net.*;
import java.util.*;

public class ServerSide {

    public static boolean isPalindrome(int number) {
        int originalNumber = number;
        int reversedNumber = 0;

        while (number != 0) {
            int digit = number % 10;
            reversedNumber = reversedNumber * 10 + digit;
            number /= 10;
        }

        return originalNumber == reversedNumber;
    }

    public static void main(String[] args) throws IOException {
        try {
            ServerSocket s = new ServerSocket(8080);
            Socket ClientSocket = s.accept();
            Scanner ins = new Scanner(ClientSocket.getInputStream());
            PrintWriter outs = new PrintWriter(ClientSocket.getOutputStream(), true);

            int Data = ins.nextInt();
            outs.println(isPalindrome(Data));

            ins.close();
            outs.close();
            ClientSocket.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}