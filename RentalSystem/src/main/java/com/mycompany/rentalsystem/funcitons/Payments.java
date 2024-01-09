package com.mycompany.rentalsystem.funcitons;

public class Payments {
    private static int paymentId = 90000;
    private static Integer count = 0;

    public Payments() {
        paymentId++;
        count++;
    }

    public static int getPaymentId() {
        return paymentId++;
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
