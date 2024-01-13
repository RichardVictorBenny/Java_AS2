package com.mycompany.rentalsystem.funcitons;

/**
 * class to keep track of payment id's
 * @author Richard
 */
public class Payments {
    private static int paymentId = 90000;
    private static Integer count = 0;

    /**
     * constructor of the class.
     */
    public Payments() {
        paymentId++;
        count++;
    }

    /*
     * getters and setters.
     */
    public static int getPaymentId() {
        return paymentId+=1;
    }

    public static void setPaymentId(int paymentId) {
        Payments.paymentId = paymentId;
    }

    public static Integer getCount() {
        return count;
    }

    public static void setCount() {
        count++;
    }

}
