package com.example.customlistview;
import static androidx.recyclerview.widget.RecyclerView.*;

import android.content.Context;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter{
    private List<Khoahoc> listData;
    private LayoutInflater layoutInflater;
    private Context context;
    //Khai báo Constructor CustomListAdapter
    public CustomListAdapter(Context aContext,List<Khoahoc>listData){
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.list_item_layout,null);
            holder = new ViewHolder();
            holder.imagekhoahoc = (ImageView) convertView.findViewById(R.id.imageViewCourse);
            holder.tenkhoahoc = (TextView) convertView.findViewById(R.id.textViewcoursename);
            holder.hocphi = (TextView) convertView.findViewById(R.id.textViewcoursfee);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Khoahoc khoahoc = this.listData.get(position);
        holder.tenkhoahoc.setText(khoahoc.getTenkhoahoc());
        holder.hocphi.setText("Học phí : " +khoahoc.getHocphi());
        int imageId = this.getMipmapResIdByName(khoahoc.getImagekhoahoc());
        holder.imagekhoahoc.setImageResource(imageId);
        holder.imagekhoahoc.setAdjustViewBounds(true);
        return convertView;
    }
    public int getMipmapResIdByName(String resName){
        String pkgName = context.getPackageName();
        //Trả về 0 nếu không tìm thấy
        int resID = context.getResources().getIdentifier(resName,"mipmap",pkgName);
        Log.i("CustomListView","Res Name: " + resName+"==> Res ID = "+resID);
        return resID;
    }
    static class ViewHolder{
        ImageView imagekhoahoc;
        TextView tenkhoahoc;
        TextView hocphi;
    }
}
