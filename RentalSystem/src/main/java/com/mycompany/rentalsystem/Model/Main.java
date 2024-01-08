

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.util.Scanner;

import com.mycompany.rentalsystem.funcitons.SentEmail;

public class Main{
     public static void main(String[] args) throws Exception {
        /* new SentEmail().sentMail("richardvictorbenny@gmail.com", 
        "test email", """
            Hi,
            test 1
        """); */

        Scanner in = new Scanner(Main.class.getResourceAsStream("SESSION.txt"));
        String read = in.nextLine();
        System.out.println(read);
        in.close();
     }
}