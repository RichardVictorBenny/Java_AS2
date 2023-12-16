import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TestHashing {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(doHashing("9090","Admin"));

    }
 
    public static String doHashing(String password, String username) throws NoSuchAlgorithmException{
        String passwordText = username + password;
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.update(passwordText.getBytes()); 
        byte[] encodedPasswordArray = digest.digest();

        StringBuilder encodedPassword = new StringBuilder();
        for (byte b : encodedPasswordArray){
            encodedPassword.append(Integer.toHexString(0xFF & b));
        }
        System.out.println(username + "," + encodedPassword.toString());

        return encodedPassword.toString();
    }
}
