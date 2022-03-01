package com.inchub.bookinpal;

public class Mains {

    private String PackageName;
    private String PackageDestination;
    private String ImageUrl;
    private String ImageUrls;
    private String ImageUrlz;


    private String InBio;
    private String OutMoney;
    private String OutBio;
    private String Tips;
    private String HighGood;

    public String getInBio() {
        return InBio;
    }

    public void setInBio(String inBio) {
        InBio = inBio;
    }

    public String getOutMoney() {
        return OutMoney;
    }

    public void setOutMoney(String outMoney) {
        OutMoney = outMoney;
    }

    public String getOutBio() {
        return OutBio;
    }

    public void setOutBio(String outBio) {
        OutBio = outBio;
    }

    public String getTips() {
        return Tips;
    }

    public void setTips(String tips) {
        Tips = tips;
    }

    public String getHighGood() {
        return HighGood;
    }

    public void setHighGood(String highGood) {
        HighGood = highGood;
    }

    public Mains(String inBio, String outMoney, String outBio, String tips, String highGood) {
        InBio = inBio;
        OutMoney = outMoney;
        OutBio = outBio;
        Tips = tips;
        HighGood = highGood;
    }

    public String getImageUrlz() {
        return ImageUrlz;
    }

    public void setImageUrlz(String imageUrlz) {
        ImageUrlz = imageUrlz;
    }

    public Mains(String imageUrlz) {
        ImageUrlz = imageUrlz;
    }

    private String PackageBio;
    private String PackageStops;
    private String PackageMails;

    public String getPackageStops() {
        return PackageStops;
    }

    public void setPackageStops(String packageStops) {
        PackageStops = packageStops;
    }

    public String getPackageMails() {
        return PackageMails;
    }

    public void setPackageMails(String packageMails) {
        PackageMails = packageMails;
    }

    public String getImageUrls() {
        return ImageUrls;
    }

    public void setImageUrls(String imageUrls) {
        ImageUrls = imageUrls;
    }

    public String getPackageBio() {
        return PackageBio;
    }

    public void setPackageBio(String packageBio) {
        PackageBio = packageBio;
    }

    public Mains(String imageUrls, String packageBio, String packageStops, String packageMails) {
        ImageUrls = imageUrls;
        PackageBio = packageBio;
        PackageStops = packageStops;
        PackageMails = packageMails;
    }

    public String getPackageName() {
        return PackageName;
    }

    public void setPackageName(String packageName) {
        PackageName = packageName;
    }

    public String getPackageDestination() {
        return PackageDestination;
    }

    public void setPackageDestination(String packageDestination) {
        PackageDestination = packageDestination;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public Mains() {
    }

    public Mains(String packageName, String packageDestination, String imageUrl) {
        PackageName = packageName;
        PackageDestination = packageDestination;
        ImageUrl = imageUrl;
    }
}
