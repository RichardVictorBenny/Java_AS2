

import com.mycompany.rentalsystem.funcitons.SentEmail;

public class Main{
     public static void main(String[] args) throws Exception {
        new SentEmail().sentMail("richardvictorbenny@gmail.com", 
        "test email", """
            Hi,
            test 1
        """);
     }
}