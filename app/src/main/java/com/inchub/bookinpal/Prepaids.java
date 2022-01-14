package com.inchub.bookinpal;

public class Prepaids {

    private String ids;
    private String province;
    private String location;
    private String calender;
    private String invite;
    private String info;
    private String mode;

    public Prepaids(String ids, String province, String location, String calender, String invite, String info, String mode) {
        this.ids = ids;
        this.province = province;
        this.location = location;
        this.calender = calender;
        this.invite = invite;
        this.info = info;
        this.mode = mode;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCalender() {
        return calender;
    }

    public void setCalender(String calender) {
        this.calender = calender;
    }

    public String getInvite() {
        return invite;
    }

    public void setInvite(String invite) {
        this.invite = invite;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Prepaids() {
    }
}
