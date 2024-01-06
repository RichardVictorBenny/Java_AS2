package com.mycompany.rentalsystem.funcitons;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileConvertion {
    public static byte[] toByteArray(Object objectToConvert){
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos;
            try {
                oos = new ObjectOutputStream(bos);
                oos.writeObject(objectToConvert);
                
            } catch (IOException e) {
                e.printStackTrace();
            }
            byte[] object = bos.toByteArray();
            return object;
    }

     public static Object toObject(byte[] byteArray){
        ByteArrayInputStream byteArrInpStm = new ByteArrayInputStream(byteArray);
        ObjectInputStream objInpStm;
        Object Obj;
        try {
            objInpStm = new ObjectInputStream(byteArrInpStm);
            Obj = (Object) objInpStm.readObject();
            return Obj;
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return null;
       
     }
}