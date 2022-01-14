package com.inchub.bookinpal;

public class Swapping {

    private String HouseMails;
    private String ConfirmHouseMails;

    public String getHouseMails() {
        return HouseMails;
    }

    public void setHouseMails(String houseMails) {
        HouseMails = houseMails;
    }

    public String getConfirmHouseMails() {
        return ConfirmHouseMails;
    }

    public void setConfirmHouseMails(String confirmHouseMails) {
        ConfirmHouseMails = confirmHouseMails;
    }

    public Swapping(String houseMails, String confirmHouseMails) {
        HouseMails = houseMails;
        ConfirmHouseMails = confirmHouseMails;
    }

    public Swapping() {
    }
}
