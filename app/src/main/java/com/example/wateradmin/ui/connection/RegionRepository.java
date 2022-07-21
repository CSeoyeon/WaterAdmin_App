package com.example.wateradmin.ui.connection;

import android.util.Log;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegionRepository {

    private static final RegionRepository INSTANCE = new RegionRepository();
    private final Executor executor = Executors.newSingleThreadExecutor();


    private RegionRepository(){

    }

    public static RegionRepository getInstance()
    {
        return INSTANCE;
    }

    //object로 받아온 다음에 필요한 부분만 형식(List, hashmap 등. . ) 맞춰서 사용
    public void getRegions(RepositoryCallback<List<String>> callback) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                Call<List<Results>> call = RetrofitClient.getInstance().getMyApi().getRegions();
                call.enqueue(new Callback<List<Results>>() {
                    @Override
                    public void onResponse(Call<List<Results>> call, Response<List<Results>> response) {
                        List<Results> regionRecordList = response.body();
                        List<String> toReturnRegion = new ArrayList<>();
                        List<String> toReturnRegionWaterTax = new ArrayList<>();

                        for (int i = 0; i < regionRecordList.size(); i++) {
                            toReturnRegion.add(regionRecordList.get(i).getRegionName());
                            toReturnRegionWaterTax.add(regionRecordList.get(i).getPricePerLiter());
                        }


                        callback.onComplete(toReturnRegion, toReturnRegionWaterTax);
                        Log.v("", "" + toReturnRegionWaterTax);
                    }

                    @Override
                    public void onFailure(Call<List<Results>> call, Throwable t) {
                        Log.v("failed", "error" + t.getMessage());
                    }
                });
            }
        });


    }

    public interface RepositoryCallback<T>
    {
        //void onComplete(T result);
        void onComplete(T regionResult, T regionWaterTaxList);
    }

    public HashMap<ArrayList<String>, ArrayList<String>> RegionWaterTaxPair(ArrayList<String> region, ArrayList<String> waterTax){
        HashMap<ArrayList<String>, ArrayList<String>> pairWaterTax = new HashMap<>();
        for(Object t : region){
            pairWaterTax.put(region, waterTax);
        }

        return pairWaterTax;
    }
}
