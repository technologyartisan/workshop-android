package id.technologyartisan.workshopandroid.model;

import android.provider.BaseColumns;

import com.google.gson.annotations.SerializedName;

public class Contact {
    private int id;
    private String name;

    @SerializedName("phone_number")
    private String number;
    private String picture;

    public Contact(int id, String name, String number, String picture) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public static class Entry implements BaseColumns {
        public static final String TABLE_NAME="contact";
        public static final String COLUMN_ID="id";
        public static final String COLUMN_NAME="name";
        public static final String COLUMN_NUMBER="number";
        public static final String COLUMN_PICTURE="picture";
    }
}
