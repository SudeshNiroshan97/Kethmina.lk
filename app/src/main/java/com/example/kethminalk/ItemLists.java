package com.example.kethminalk;

public class ItemLists {

 private String mName;
 private String mCompany;
 private String mLocation;


    public ItemLists(String mName, String mCompany, String mLocation) {
        this.mName = mName;
        this.mCompany = mCompany;
        this.mLocation = mLocation;
    }


    public ItemLists() {

    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmCompany() {
        return mCompany;
    }

    public void setmCompany(String mCompany) {
        this.mCompany = mCompany;
    }

    public String getmLocation() {
        return mLocation;
    }

    public void setmLocation(String mLocation) {
        this.mLocation = mLocation;
    }

    @Override
    public String toString() {
        return "ItemLists{" +
                "mName='" + mName + '\'' +
                ", mCompany='" + mCompany + '\'' +
                ", mLocation='" + mLocation + '\'' +
                '}';
    }
}
