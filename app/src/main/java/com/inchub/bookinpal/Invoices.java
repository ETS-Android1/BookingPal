package com.inchub.bookinpal;

public class Invoices {

    private String InvNumber;
    private String InvEmail;
    private String InvNames;
    private String InvTour;

    public String getInvNumber() {
        return InvNumber;
    }

    public void setInvNumber(String invNumber) {
        InvNumber = invNumber;
    }

    public String getInvEmail() {
        return InvEmail;
    }

    public void setInvEmail(String invEmail) {
        InvEmail = invEmail;
    }

    public String getInvNames() {
        return InvNames;
    }

    public void setInvNames(String invNames) {
        InvNames = invNames;
    }

    public String getInvTour() {
        return InvTour;
    }

    public void setInvTour(String invTour) {
        InvTour = invTour;
    }

    public Invoices(String invNumber, String invEmail, String invNames, String invTour) {
        InvNumber = invNumber;
        InvEmail = invEmail;
        InvNames = invNames;
        InvTour = invTour;
    }

    public Invoices() {
    }
}
