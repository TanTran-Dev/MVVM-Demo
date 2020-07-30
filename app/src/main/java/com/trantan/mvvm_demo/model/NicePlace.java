package com.trantan.mvvm_demo.model;

public class NicePlace {
    private String tittle;
    private String imageUrl;

    public NicePlace(String tittle, String imageUrl) {
        this.tittle = tittle;
        this.imageUrl = imageUrl;
    }

    public NicePlace() {
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
