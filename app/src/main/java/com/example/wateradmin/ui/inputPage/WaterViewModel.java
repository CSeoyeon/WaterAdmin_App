package com.example.wateradmin.ui.inputPage;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class WaterViewModel extends ViewModel {

    private final MutableLiveData<Integer> laundry, washCar, shower, userInput, washDish;

    private String IngestionPerson, carWashTime, showerTime, userInputTime;

    public WaterViewModel(){
        laundry = new MutableLiveData<>();
        washCar = new MutableLiveData<>();
        shower = new MutableLiveData<>();
        userInput = new MutableLiveData<>();
        washDish = new MutableLiveData<>();

    }

    public LiveData<Integer> getLaundry(){return laundry;}
    public LiveData<Integer> getWashCar(){ return washCar;}
    public LiveData<Integer> getWashDish(){return washDish;}
    public LiveData<Integer> getUserInput(){ return userInput;}
    public LiveData<Integer> getShower(){ return shower;}

    public String getIngenstionPerson() {return IngestionPerson;}

    public void setIngestionPerson(String IngestionPerson){this.IngestionPerson = IngestionPerson; }

    public String getCarWash() {return carWashTime;}

    public void setCarWash(String carWashTime) {
        this.carWashTime = carWashTime;
    }

    public String getshowerTime() {
        return showerTime;
    }

    public void setshowerTime(String showerTime) {
        this.showerTime = showerTime;
    }

    public String getUserInputtedTime() {
        return userInputTime;
    }

    public void setUserInputtedTime(String userInputTime) {
        this.userInputTime = userInputTime;
    }


}
