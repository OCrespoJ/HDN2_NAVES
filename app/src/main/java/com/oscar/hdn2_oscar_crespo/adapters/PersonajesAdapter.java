package com.oscar.hdn2_oscar_crespo.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.oscar.hdn2_oscar_crespo.R;

import java.util.List;

import com.oscar.hdn2_oscar_crespo.beans.PersonajeBean;

public class PersonajesAdapter extends ArrayAdapter <PersonajeBean>{
    private Context context;
    private int resource;
    private List<PersonajeBean> objects;

    public PersonajesAdapter(Context context, int resource, List<PersonajeBean> objects) {
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
        PersonajeBean personajeBean = objects.get(position);
        viewHolder.txtNombre.setText(personajeBean.getNombre());

        return view;
    }
}
