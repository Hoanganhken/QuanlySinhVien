package com.example.hoanganhken.quanlysinhvien;

import java.util.ArrayList;

/**
 * Created by Hoang Anh Ken on 10/23/2017.
 */

public class data {
    public  static data dt;
    ArrayList<SinhVien> arrSV;
    static {
        dt = new data();

    }
    public static data getDt(){
        return dt;
    }
}
