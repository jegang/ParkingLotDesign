package com.jegan.Payments;

import com.jegan.models.PaymentStatus;

import java.util.Date;

public class Payment {
    private Date creationDate;
    private double amount;
    private PaymentStatus paymentStatus;


    public boolean initiateTransaction(){
        System.out.println("Successfully Paid : Amount : " + amount + "Transaction Date : " + creationDate);
        paymentStatus = PaymentStatus.COMPLETE;
        return true;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PaymentStatus getPaystat() {
        return paymentStatus;
    }

    public void setPaystat(PaymentStatus paystat) {
        this.paymentStatus = paystat;
    }
}
