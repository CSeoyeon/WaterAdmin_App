package com.example.wateradmin.ui.inputPage.model;

import androidx.annotation.Nullable;

import java.util.Calendar;

public class UsageRecordDate {
    private final int year;
    private final int month;
    private final int day;

    public UsageRecordDate(long timeInMillis) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(timeInMillis);
        this.year = c.get(Calendar.YEAR);
        this.month = c.get(Calendar.MONTH);
        this.day = c.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof UsageRecordDate))
            return false;
        UsageRecordDate compareDate = ((UsageRecordDate) obj);
        if (year != compareDate.getYear())
            return false;
        if (month != compareDate.getMonth())
            return false;
        if (day != compareDate.getDay())
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        return (year * 525600) +
                (month * 43800) +
                (day * 1440);
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
}
