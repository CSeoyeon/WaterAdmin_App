package com.example.wateradmin.ui.connection;

import com.google.gson.annotations.SerializedName;

public class Results {

    @SerializedName("regionName")
    private String regionName;

    @SerializedName("pricePerLiter")
    private String pricePerLiter;

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getPricePerLiter() {
        return pricePerLiter;
    }

    public void setPricePerLiter(String pricePerLiter) {
        this.pricePerLiter = pricePerLiter;
    }
}
