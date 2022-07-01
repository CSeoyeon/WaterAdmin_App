package com.example.wateradmin.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private String usedWater, waterTax;


    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public String getUsedWater() {
        return usedWater;
    }

    public void setUsedWater(String usedWater) {
        this.usedWater = usedWater;
    }

    public String getWaterTax() {
        return waterTax;
    }

    public void setWaterTax(String waterTax) {
        this.waterTax = waterTax;
    }
}