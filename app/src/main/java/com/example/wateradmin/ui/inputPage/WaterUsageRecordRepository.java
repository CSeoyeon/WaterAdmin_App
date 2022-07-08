package com.example.wateradmin.ui.inputPage;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WaterUsageRecordRepository {
    private static final WaterUsageRecordRepository INSTANCE = new WaterUsageRecordRepository();

    private List<UsedWaterInputLaundryRecord> allUsageRecords;
    private Map<UsageRecordDate, List<UsedWaterInputLaundryRecord>> dateUsageRecordsMap;

    //private List<WaterUsageRecord> allUsageRecords;
    //private Map<UsageRecordDate, List<WaterUsageRecord>> dateUsageRecordsMap;

    private List<UsedWaterInputLaundryRecord> laundryRecords = new ArrayList<>();
    private Map<UsageRecordDate, List<WaterUsageRecord>> datelaundryRecordsMap = new HashMap<UsageRecordDate, List<WaterUsageRecord>>();

    //record
    private UsedWaterInputLaundryRecord addLaundry;
    private UsedWaterInputShowerRecord addShower;
    private UsedWaterInputWashdishRecord addWashdish;
    private UsedWaterInputWashCarRecord addWashCar;
    private UsedWaterInputUserInputRecord addUserInput;

    //record tag
    private static String laundryTag, showerTag, washdishTag, washCarTag, userInputTag;

    //record date
    private UsageRecordDate laundryDate, showerDate, washdishDate, washCarDatem, userInputDate;

    //물 사용량
    private static double laundryAmount, showerAmount, washdishAmount, washCarAmount, userInputAmount;

    //각각 사용량, 수도세
    private double laundryWaterTax, showerWaterTax, washdishWaterTax, washCarWaterTax, userInputWaterTax;

    //총량 사용량, 수도세
    private static double allUsedAmount, allUsedWaterTax;

    private WaterUsageRecordRepository() {
        allUsageRecords = new ArrayList<>();
        dateUsageRecordsMap = new HashMap<>();
    }

    public static WaterUsageRecordRepository getInstance() {
        return INSTANCE;
    }


    //계산(사용량, 수도세)
    public UsedWaterInputLaundryRecord getAddLaundry() {
        return addLaundry;
    }

    public double setAddLaundry(UsedWaterInputLaundryRecord addLaundry) {
        this.addLaundry = addLaundry;
        laundryAmount = addLaundry.getUsedWaterAmount();
        laundryTag = (addLaundry.getLaundryType()).toString();
        laundryDate = addLaundry.getDate();
        laundryWaterTax = CalculateWaterTax(laundryWaterTax, laundryAmount);

        Log.v("세탁 물 사용량", " "+laundryAmount);
        Log.v("세탁 수도세", " "+laundryWaterTax);
        Log.v("세탁 date", ""+laundryDate);

        return laundryAmount;
    }

    public UsedWaterInputShowerRecord getAddShower() {
        return addShower;
    }

    public double setAddShower(UsedWaterInputShowerRecord addShower) {
        this.addShower = addShower;
        showerAmount = addShower.getUsedShowerWaterAmount();
        showerTag = addShower.getShowerType();


        Log.v("샤워", " "+showerAmount);

        return showerAmount;
    }

    public UsedWaterInputWashdishRecord getAddWashdish() {
        return addWashdish;
    }

    public double setAddWashdish(UsedWaterInputWashdishRecord addWashdish) {
        this.addWashdish = addWashdish;
        washdishAmount = addWashdish.getUsedWashDishWaterAmount();
        washdishTag = (addWashdish.getDishType()).toString();

        Log.v("설거지", " "+showerAmount);
        return washdishAmount;
    }

    public UsedWaterInputWashCarRecord getAddWashCar() {
        return addWashCar;
    }

    public double setAddWashCar(UsedWaterInputWashCarRecord addWashCar) {
        this.addWashCar = addWashCar;
        washCarAmount = addWashCar.getUseWashCarWaterAmount();
        washCarTag = addWashCar.getCarWashType();
        Log.v("세차", " "+washCarAmount);

        return washCarAmount;
    }

    public UsedWaterInputUserInputRecord getAddUserInput() {
        return addUserInput;
    }

    public double setAddUserInput(UsedWaterInputUserInputRecord addUserInput) {
        this.addUserInput = addUserInput;
        userInputAmount = addUserInput.getUsedWater();
        userInputTag = addUserInput.getUsedType();
        Log.v("사용자 입력", " "+userInputAmount );
        return userInputAmount;
    }


    public double CalculateWaterTax(double waterTax, double UsedAmount){
        if(UsedAmount >= 0 && UsedAmount <= 20000){
            waterTax = UsedAmount * 460;
            return waterTax;
        }
        else if(UsedAmount >= 21000 && UsedAmount <40000){
            waterTax = UsedAmount * 720;
            return waterTax;
        }
        else{
            waterTax = UsedAmount * 950;
            return waterTax; }
    }


    public double allCalculateWaterAmount(double laundryAmount, double showerAmount, double washCarAmount, double washdishAmount, double userInputAmount) {
        allUsedAmount += laundryAmount + showerAmount + washCarAmount + userInputAmount +washdishAmount;
        return allUsedAmount;
    }

    public double allCalculateWaterTax(double laundryWaterTax, double showerWaterTax, double washCarWaterTax, double washdishWaterTax, double userInputWaterTax){
        allUsedWaterTax = laundryWaterTax + showerWaterTax + washCarWaterTax + washdishWaterTax + userInputWaterTax;
        return allUsedWaterTax;
    }

    public double setCalculateWaterAmount(){
        allCalculateWaterAmount(laundryAmount, showerAmount, washCarAmount, washdishAmount, userInputAmount);
        return allUsedAmount;
    }

    public double setCalculateWaterTax(){
        allCalculateWaterTax(laundryWaterTax, showerWaterTax,  washCarWaterTax,  washdishWaterTax, userInputWaterTax);
        return allUsedWaterTax;
    }



    //tag
    public static String getLaundryTag() {
        return laundryTag;
    }

    public static void setLaundryTag(String laundryTag) {
        WaterUsageRecordRepository.laundryTag = laundryTag;
    }

    public static String getShowerTag() {
        return showerTag;
    }

    public static void setShowerTag(String showerTag) {
        WaterUsageRecordRepository.showerTag = showerTag;
    }

    public static String getWashdishTag() {
        return washdishTag;
    }

    public static void setWashdishTag(String washdishTag) {
        WaterUsageRecordRepository.washdishTag = washdishTag;
    }

    public static String getWashCarTag() {
        return washCarTag;
    }

    public static void setWashCarTag(String washCarTag) {
        WaterUsageRecordRepository.washCarTag = washCarTag;
    }

    public static String getUserInputTag() {
        return userInputTag;
    }

    public static void setUserInputTag(String userInputTag) {
        WaterUsageRecordRepository.userInputTag = userInputTag;
    }

    public void addLaundryRecord(String laundryTag, double laundryAmount, double laundryWaterTax, UsageRecordDate date){


    }
}
