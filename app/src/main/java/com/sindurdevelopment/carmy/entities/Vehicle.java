package com.sindurdevelopment.carmy.entities;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Vehicle implements Parcelable {

    private String name;
    private String VIN;
    public Vehicle(String VIN) {
        this.VIN = VIN;
        name="";
    }

    public Vehicle(String name, String VIN) {
        this.name = name;
        this.VIN = VIN;
    }


    protected Vehicle(Parcel in) {
        name = in.readString();
        VIN = in.readString();
    }

    public static final Creator<Vehicle> CREATOR = new Creator<Vehicle>() {
        @Override
        public Vehicle createFromParcel(Parcel in) {
            return new Vehicle(in);
        }

        @Override
        public Vehicle[] newArray(int size) {
            return new Vehicle[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(VIN);
    }
}
