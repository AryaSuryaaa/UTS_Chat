package com.surya.utschat;

public class ItemList {
    private String imageUrl, nama, displayTime, displayText;

    public ItemList(String imageUrl, String nama, String displayTime, String displayText) {
        this.imageUrl = imageUrl;
        this.nama = nama;
        this.displayTime = displayTime;
        this.displayText = displayText;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDisplayTime() {
        return displayTime;
    }

    public void setDisplayTime(String displayTime) {
        this.displayTime = displayTime;
    }

    public String getDisplayText() {
        return displayText;
    }

    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }
}
