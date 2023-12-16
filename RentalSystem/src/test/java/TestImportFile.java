/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * https://www.codejava.net/java-se/file-io/how-to-read-and-write-binary-files-in-java
 * Java lecture notes
 * https://www.youtube.com/watch?v=7S7tnaOqKss
 * 
 * @author Richard
 */
public class TestImportFile {

    public static void main(String[] args) {
        String filename = "src/main/java/com/mycompany/rentalsystem/files/AdminLogin.bin";
        ArrayList<String> credentials = new ArrayList<>();
        
        FileOutputStream fileOs;
        try {
            fileOs = new FileOutputStream(filename);
            ObjectOutputStream os = new ObjectOutputStream(fileOs);
            os.writeUTF("Richard-3159883d9e92bd2589296c21ac2c6edf1df54193d08ca8a86f87eba6aa0bb");
            os.writeUTF("Admin-25f3150e6cfd21250831f797b2e7e792d4ee8ba7a8e98db22b4fe1fd69821");
            os.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done writing");
        System.out.println("now reading");

        FileInputStream fileIn;
        try {
            fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);

            while (true) {
                try {
                    credentials.add(in.readUTF());
                    //System.out.println(in.readUTF());
                } catch (EOFException eof) {
                    break;
                }
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        } 
        finally{
            System.out.println(credentials);
        }
        

    }

}
