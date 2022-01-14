package com.inchub.bookinpal;

public class Travel {

    private String usermail;
    private String travelprovince;
    private String travellocation;
    private String traveldates;
    private String travelfam;
    private String travelinfo;

    public Travel(String usermail, String travelprovince, String travellocation, String traveldates, String travelfam, String travelinfo) {
        this.usermail = usermail;
        this.travelprovince = travelprovince;
        this.travellocation = travellocation;
        this.traveldates = traveldates;
        this.travelfam = travelfam;
        this.travelinfo = travelinfo;
    }

    public String getUsermail() {
        return usermail;
    }

    public void setUsermail(String usermail) {
        this.usermail = usermail;
    }

    public String getTravelprovince() {
        return travelprovince;
    }

    public void setTravelprovince(String travelprovince) {
        this.travelprovince = travelprovince;
    }

    public String getTravellocation() {
        return travellocation;
    }

    public void setTravellocation(String travellocation) {
        this.travellocation = travellocation;
    }

    public String getTraveldates() {
        return traveldates;
    }

    public void setTraveldates(String traveldates) {
        this.traveldates = traveldates;
    }

    public String getTravelfam() {
        return travelfam;
    }

    public void setTravelfam(String travelfam) {
        this.travelfam = travelfam;
    }

    public String getTravelinfo() {
        return travelinfo;
    }

    public void setTravelinfo(String travelinfo) {
        this.travelinfo = travelinfo;
    }

    public Travel() {
    }
}
