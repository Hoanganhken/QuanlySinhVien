package com.example.hoanganhken.quanlysinhvien;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Hoang Anh Ken on 10/23/2017.
 */

public class SinhvienAdapter extends ArrayAdapter<SinhVien> {
    ArrayList<SinhVien> arr;
    Context ct;


    public SinhvienAdapter(Context context, int resource) {
        super(context, resource);
        this.ct = context;
        this.arr = new ArrayList<>(data.getDt().arrSV);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        viewHodler v;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.item_sinhvien, null);

            v = new viewHodler(row);
            if (arr.size()>0){
                v.setView(arr.get(position));
            }
            return row;
        }
        return super.getView(position, convertView, parent);
    }

    class viewHodler {

        TextView txtTen, txtSdt, txtEmail, txtxlop;
        ImageView imgGT;
        public viewHodler(View v){
            txtTen = v.findViewById(R.id.txtTen);
            txtSdt = v.findViewById(R.id.txtSDT);
            txtEmail = v.findViewById(R.id.txtEmail);
            txtxlop = v.findViewById(R.id.txtlop);
            imgGT = v.findViewById(R.id.imgGT);
        }
        public  void setView(SinhVien sv){
            txtTen.setText(sv.getTen());
            txtSdt.setText(sv.getSdt());
            txtxlop.setText(sv.getLopHoc());
            txtEmail.setText(sv.getEmail());
            if(sv.getGioiTinh().equals("nu")){
                imgGT.setImageResource(R.drawable.girl);
            }else {
                imgGT.setImageResource(R.drawable.boy);
            }
        }
    }
}
