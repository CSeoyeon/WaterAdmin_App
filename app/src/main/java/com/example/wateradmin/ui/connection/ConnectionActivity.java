package com.example.wateradmin.ui.connection;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wateradmin.ui.inputPage.fragment.LocalInputFragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConnectionActivity extends AppCompatActivity {
    public static final String[] siDo =new String[]{};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getRegions();
    }

    public void getRegions() {
        Call<List<Results>> call = RetrofitClient.getInstance().getMyApi().getRegions();
        call.enqueue(new Callback<List<Results>>() {

            @Override
            public void onResponse(Call<List<Results>> call, Response<List<Results>> response) {
                List<Results> regionRecordList = response.body();
                for (int i = 0; i < regionRecordList.size(); i++) {
                    siDo[i] = regionRecordList.get(i).getRegionName();
                    Log.v("", "" + siDo[i]);
                }
            }

            @Override
            public void onFailure(Call<List<Results>> call, Throwable t) {
                //Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
            }

        });

    }


}