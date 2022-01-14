package com.inchub.bookinpal;

public class Mains {

    private String PackageName;
    private String PackageDestination;
    private String ImageUrl;
    private String ImageUrls;
    private String ImageUrlz;

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
