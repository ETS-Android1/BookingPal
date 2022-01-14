package com.inchub.bookinpal;

public class Swap {

    private String mails;
    private String locays;
    private String cellphone;
    private String confirm;

    public Swap(String mails, String locays, String cellphone, String confirm) {
        this.mails = mails;
        this.locays = locays;
        this.cellphone = cellphone;
        this.confirm = confirm;
    }

    public Swap() {

    }

    public String getMails() {
        return mails;
    }

    public void setMails(String mails) {
        this.mails = mails;
    }

    public String getLocays() {
        return locays;
    }

    public void setLocays(String locays) {
        this.locays = locays;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }
}
