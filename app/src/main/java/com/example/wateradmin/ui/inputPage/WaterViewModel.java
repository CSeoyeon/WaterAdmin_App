package com.example.wateradmin.ui.inputPage;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class WaterViewModel extends ViewModel {

    private final MutableLiveData<Integer> laundry, washCar, shower, userInput, washDish;



    public WaterViewModel(MutableLiveData<Integer> mText){
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



}
