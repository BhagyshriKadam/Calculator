package com.bhagyshrikadam.calculator.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bhagyshrikadam.calculator.R;
import com.bhagyshrikadam.calculator.models.History;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<History> {
    private Activity activity;
    private List<History> mExampleList;
    private List<History> itemList;

    public ListViewAdapter(Activity activity, int resource, List<History> itemList) {
        super(activity, resource, itemList);
        this.activity = activity;
        this.mExampleList = itemList;
        this.itemList = itemList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        LayoutInflater inflater = (LayoutInflater) activity
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        // If holder not exist then locate all view from UI file.
        if (convertView == null) {
            // inflate UI from XML file
            convertView = inflater.inflate(R.layout.item_listview, parent, false);
            // get all UI view
            holder = new ViewHolder(convertView);
            // set tag for holder
            convertView.setTag(holder);
        } else {
            // if holder created, get tag from view
            holder = (ViewHolder) convertView.getTag();
        }

        History history = getItem(position);

        holder.Calculation.setText(history.getCalculation());
        holder.Result.setText(history.getResult());

        return convertView;
    }
    public int getCount() {
        if (mExampleList.size()>10){
            return 10;
        }
        return mExampleList.size(); }
    private static class ViewHolder {
        private TextView Calculation;
        private TextView Result;

        public ViewHolder(View v) {
            Calculation = (TextView) v.findViewById(R.id.calculation);
            Result = (TextView) v.findViewById(R.id.result);
        }
    }
}
