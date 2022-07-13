package com.example.wateradmin.ui.recordPage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.wateradmin.R;
import com.example.wateradmin.databinding.FragmentRecordlistBinding;
import com.example.wateradmin.databinding.FragmentRecordlistitemBinding;
import com.example.wateradmin.ui.inputPage.model.UsageRecordDate;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RecordListAdapter extends BaseAdapter {

    FragmentRecordlistitemBinding binding;

    private TextView tv_date;
    private TextView tv_usedWater;
    private TextView tv_usedWaterTax;


    private ArrayList<RecordListItem> listViewItemList = new ArrayList<RecordListItem>();

    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final int position =i;
        final Context context = viewGroup.getContext();

        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.fragment_recordlistitem, viewGroup, false);
        }

         tv_date = binding.recordListItemTvDate;
         tv_usedWater = binding.recordListItemTvUsedWater;
         tv_usedWaterTax = binding.recordListItemTvUsedWaterTax;

         RecordListItem recordListItem = listViewItemList.get(position);

        return view;
    }

    @Override
    public Object getItem(int i) {
        return listViewItemList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public void addItem(UsageRecordDate date, double usedWater, double usedWaterTax){
        RecordListItem item = new RecordListItem(date, usedWater, usedWaterTax);
    }

}
