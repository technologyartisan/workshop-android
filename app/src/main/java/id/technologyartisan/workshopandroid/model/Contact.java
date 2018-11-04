package id.technologyartisan.workshopandroid.model;

import com.google.gson.annotations.SerializedName;

public class Contact {
    private String name;

    @SerializedName("phone_number")
    private String number;
    private String picture;

    public Contact(String name, String number, String picture) {
        this.name = name;
        this.number = number;
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
