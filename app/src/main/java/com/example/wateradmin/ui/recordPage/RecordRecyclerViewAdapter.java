package com.example.wateradmin.ui.recordPage;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wateradmin.databinding.FragmentRecordlistitemBinding;
import com.example.wateradmin.ui.inputPage.model.WaterUsageRecord;

import java.util.List;


public class RecordRecyclerViewAdapter extends RecyclerView.Adapter<RecordRecyclerViewAdapter.ViewHolder> {

    private List<WaterUsageRecord> records;

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
        holder.tv_usedWaterTax.setText("아직 없음");
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

        @Override
        public String toString()
        {
            return super.toString() + " '" + tv_usedWater.getText() + "'";
        }
    }
}