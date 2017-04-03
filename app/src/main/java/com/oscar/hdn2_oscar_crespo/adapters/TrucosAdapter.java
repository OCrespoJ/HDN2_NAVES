package com.oscar.hdn2_oscar_crespo.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.oscar.hdn2_oscar_crespo.R;
import com.oscar.hdn2_oscar_crespo.beans.TrucoBean;

import java.util.List;

/**
 * Created by oscar on 30/03/2017.
 */

public class TrucosAdapter extends ArrayAdapter<TrucoBean> {
        private Context context;
        private int resource;
        private List<TrucoBean> objects;

        public TrucosAdapter(Context context, int resource, List<TrucoBean> objects) {
            super(context, resource, objects);
            this.context = context;
            this.objects = objects;
            this.resource = resource;
        }
    class ViewHolder {
        TextView txtNombre;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder;
        if(view == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(resource, null);
            viewHolder.txtNombre = (TextView) view.findViewById(R.id.txtNombre);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        TrucoBean personajeBean = objects.get(position);
        viewHolder.txtNombre.setText(personajeBean.getNombre());

        return view;
    }
}
