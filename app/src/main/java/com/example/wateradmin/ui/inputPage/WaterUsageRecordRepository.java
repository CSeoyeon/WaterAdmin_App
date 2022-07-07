package com.example.wateradmin.ui.inputPage;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WaterUsageRecordRepository {
    private static final WaterUsageRecordRepository INSTANCE = new WaterUsageRecordRepository();

    private List<WaterUsageRecord> allUsageRecords;
    private Map<UsageRecordDate, List<WaterUsageRecord>> dateUsageRecordsMap;

    private UsedWaterInputLaundryRecord addLaundry;
    private UsedWaterInputShowerRecord addShower;
    private UsedWaterInputWashdishRecord addWashdish;
    private UsedWaterInputWashCarRecord addWashCar;
    private UsedWaterInputUserInputRecord addUserInput;

    private static double laundryAmount, showerAmount, washdishAmount, washCarAmount, userInputAmount;

    private static double  allUsedAmount, waterTax;
    
    private WaterUsageRecordRepository() {
        allUsageRecords = new ArrayList<>();
        dateUsageRecordsMap = new HashMap<>();
    }

    public static WaterUsageRecordRepository getInstance() {
        return INSTANCE;
    }

    public void addUsageRecord(WaterUsageRecord toAdd) {
        allUsageRecords.add(toAdd);
        if (dateUsageRecordsMap.containsKey(toAdd.getDate())) {
            List<WaterUsageRecord> recordsForDate = dateUsageRecordsMap.get(toAdd.getDate());
            recordsForDate.add(toAdd);
        } else {
            List<WaterUsageRecord> recordListToAdd = new ArrayList<>();
            recordListToAdd.add(toAdd);
            dateUsageRecordsMap.put(toAdd.getDate(), recordListToAdd);
        }
    }

    public List<WaterUsageRecord> getAllUsageRecords() {
        return allUsageRecords;
    }

    public List<WaterUsageRecord> getUsageRecordsForDate(UsageRecordDate date) {
        return dateUsageRecordsMap.get(date);
    }

    //record

    public UsedWaterInputLaundryRecord getAddLaundry() {
        return addLaundry;
    }

    public double setAddLaundry(UsedWaterInputLaundryRecord addLaundry) {
        this.addLaundry = addLaundry;
        laundryAmount = addLaundry.getUsedWaterAmount();

        Log.v("세탁", " "+laundryAmount);

        return laundryAmount;
    }

    public UsedWaterInputShowerRecord getAddShower() {
        return addShower;
    }

    public double setAddShower(UsedWaterInputShowerRecord addShower) {
        this.addShower = addShower;
        showerAmount = addShower.getUsedShowerWaterAmount();

        Log.v("샤워", " "+showerAmount);

        return showerAmount;
    }

    public UsedWaterInputWashdishRecord getAddWashdish() {
        return addWashdish;
    }

    public double setAddWashdish(UsedWaterInputWashdishRecord addWashdish) {
        this.addWashdish = addWashdish;
        washdishAmount = addWashdish.getUsedWashDishWaterAmount();
        Log.v("설거지", " "+showerAmount);
        return washdishAmount;
    }

    public UsedWaterInputWashCarRecord getAddWashCar() {
        return addWashCar;
    }

    public double setAddWashCar(UsedWaterInputWashCarRecord addWashCar) {
        this.addWashCar = addWashCar;
        washCarAmount = addWashCar.getUseWashCarWaterAmount();

        Log.v("세차", " "+washCarAmount);

        return washCarAmount;
    }

    public UsedWaterInputUserInputRecord getAddUserInput() {
        return addUserInput;
    }

    public double setAddUserInput(UsedWaterInputUserInputRecord addUserInput) {
        this.addUserInput = addUserInput;
        userInputAmount = addUserInput.getUsedWater();

        Log.v("사용자 입력", " "+userInputAmount );

        return userInputAmount;
    }



    public void addCalculateWaterAmount(double laundryAmount, double showerAmount, double washCarAmount, double washdishAmount, double userInputAmount) {
        allUsedAmount += laundryAmount + showerAmount + washCarAmount + userInputAmount +washdishAmount;
        addCalculateWaterTax(allUsedAmount);
    }

    public void addCalculateWaterTax(double allUsedAmount){
        if(allUsedAmount >= 0 && allUsedAmount <= 20000){
            waterTax = allUsedAmount * 460;
        }
        else if(allUsedAmount >= 21000 && allUsedAmount <40000){
            waterTax = allUsedAmount * 720;
        }
        else{ waterTax = allUsedAmount * 950; }


    }

    public double setCalculateWaterAmount(){
        addCalculateWaterAmount(laundryAmount, showerAmount, washCarAmount, washdishAmount, userInputAmount);
        return allUsedAmount;
    }

    public double setCalculateWaterTax(){
        return waterTax;
    }




}
