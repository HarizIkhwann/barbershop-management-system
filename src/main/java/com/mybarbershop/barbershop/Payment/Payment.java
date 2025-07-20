package com.mybarbershop.barbershop.Payment;

public class Payment {
    private String billName;
    private String billDescription;
    private int billPriceSetting = 1;
    private int billPayorInfo = 1;
    private double amount;
    private String billReturnUrl;
    private String billCalbackUrl;
    private String billExternalReferenceNo;
    private String billTo;
    private String billEmail;
    private String billPhone;
    private int billPaymentChannel = 2;
    private int billChargeToCustomer = 1;

    public Payment() {
    }

    public Payment(String billName, String billDescription, double amount, String billReturnUrl, String billCalbackUrl, String billExternalReferenceNo, String billTo, String billEmail, String billPhone) {
        this.billName = billName;
        this.billDescription = billDescription;
        this.amount = amount;
        this.billReturnUrl = billReturnUrl;
        this.billCalbackUrl = billCalbackUrl;
        this.billExternalReferenceNo = billExternalReferenceNo;
        this.billTo = billTo;
        this.billEmail = billEmail;
        this.billPhone = billPhone;
    }

    public String getBillName() {
        return billName;
    }

    public void setBillName(String billName) {
        this.billName = billName;
    }

    public String getBillDescription() {
        return billDescription;
    }

    public void setBillDescription(String billDescription) {
        this.billDescription = billDescription;
    }

    public int getBillPriceSetting() {
        return billPriceSetting;
    }

    public void setBillPriceSetting(int billPriceSetting) {
        this.billPriceSetting = billPriceSetting;
    }

    public int getBillPayorInfo() {
        return billPayorInfo;
    }

    public void setBillPayorInfo(int billPayorInfo) {
        this.billPayorInfo = billPayorInfo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getBillReturnUrl() {
        return billReturnUrl;
    }

    public void setBillReturnUrl(String billReturnUrl) {
        this.billReturnUrl = billReturnUrl;
    }

    public String getBillCalbackUrl() {
        return billCalbackUrl;
    }

    public void setBillCalbackUrl(String billCalbackUrl) {
        this.billCalbackUrl = billCalbackUrl;
    }

    public String getBillExternalReferenceNo() {
        return billExternalReferenceNo;
    }

    public void setBillExternalReferenceNo(String billExternalReferenceNo) {
        this.billExternalReferenceNo = billExternalReferenceNo;
    }

    public String getBillTo() {
        return billTo;
    }

    public void setBillTo(String billTo) {
        this.billTo = billTo;
    }

    public String getBillEmail() {
        return billEmail;
    }

    public void setBillEmail(String billEmail) {
        this.billEmail = billEmail;
    }

    public String getBillPhone() {
        return billPhone;
    }

    public void setBillPhone(String billPhone) {
        this.billPhone = billPhone;
    }

    public int getBillPaymentChannel() {
        return billPaymentChannel;
    }

    public void setBillPaymentChannel(int billPaymentChannel) {
        this.billPaymentChannel = billPaymentChannel;
    }

    public int getBillChargeToCustomer() {
        return billChargeToCustomer;
    }

    public void setBillChargeToCustomer(int billChargeToCustomer) {
        this.billChargeToCustomer = billChargeToCustomer;
    }
}
