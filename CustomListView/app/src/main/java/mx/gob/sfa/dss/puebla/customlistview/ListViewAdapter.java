package mx.gob.sfa.dss.puebla.customlistview;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Filter;
import java.util.logging.LogRecord;
import android.widget.Filter.FilterListener;
/**
 * Created by dtit on 07/04/16.
 */
public class ListViewAdapter extends BaseAdapter{

    private List<SearchResults> searchArrayList;
    private LayoutInflater mInflater;

    //se agrego


    public ListViewAdapter(Context context, ArrayList<SearchResults> results) {
        searchArrayList = results;
        mInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return searchArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return searchArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.listitem_row, null);
            holder = new ViewHolder();
            holder.txtName = (TextView) convertView.findViewById(R.id.name);
            holder.txtCityState = (TextView) convertView.findViewById(R.id.cityState);
            holder.txtPhone = (TextView) convertView.findViewById(R.id.phone);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtName.setText(searchArrayList.get(position).getName());
        holder.txtCityState.setText(searchArrayList.get(position)
                .getCityState());
        holder.txtPhone.setText(searchArrayList.get(position).getPhone());


        return convertView;
    }




    static class ViewHolder {
        TextView txtName;
        TextView txtCityState;
        TextView txtPhone;
    }



}



