package com.example.wateradmin.ui.recordPage;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wateradmin.databinding.FragmentRecordlistitemBinding;
import com.example.wateradmin.ui.inputPage.model.WaterUsageRecord;

import java.util.ArrayList;
import java.util.List;


public class RecordRecyclerViewAdapter extends RecyclerView.Adapter<RecordRecyclerViewAdapter.ViewHolder> {


    private List<WaterUsageRecord> records;

    private ArrayList<RecordListItem> recordItem;

    public RecordRecyclerViewAdapter(List<WaterUsageRecord> items)
    {
        this.records = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        return new ViewHolder(FragmentRecordlistitemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position)
    {
        WaterUsageRecord currRecord = records.get(position);

        holder.tv_date.setText(currRecord.getFormatDate());
        holder.tv_usedWater.setText(String.valueOf(currRecord.getUsedAmountInLiters()));
        holder.tv_usedWaterTax.setText(String.valueOf(currRecord.getWaterTax()));

        //holder.onBind(recordItem.get(position));

    }


    @Override
    public int getItemCount()
    {
        return records.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        protected TextView tv_usedWater;
        protected TextView tv_date;
        protected TextView tv_usedWaterTax;
        public ViewHolder(FragmentRecordlistitemBinding binding)
        {
            super(binding.getRoot());

            tv_date = binding.recordListItemTvDate;
            tv_usedWater = binding.recordListItemTvUsedWater;
            tv_usedWaterTax = binding.recordListItemTvUsedWaterTax;
        }

        protected void onBind(RecordListItem items){
            tv_date.setText(items.getTv_date().toString());
            tv_usedWater.setText(String.valueOf(items.getTv_usedWater()));
            tv_usedWaterTax.setText(String.valueOf(items.getTv_usedWaterTax()));

        }

        @Override
        public String toString()
        {
            return super.toString() + " '" + tv_usedWater.getText() + "'";
        }
    }
}