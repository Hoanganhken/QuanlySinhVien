package com.example.hoanganhken.quanlysinhvien;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lsvSinhvien;
    SinhvienAdapter adapter;
    TuongtacDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lsvSinhvien=(ListView) findViewById(R.id.lsvSinhvien);
        database = new TuongtacDatabase(this);

        getDATA();
        adapter = new SinhvienAdapter(this,0);
        lsvSinhvien.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.trangChu:
                break;
            case R.id.timkiem:
                break;
            case R.id.dkhoc:
                break;
            case R.id.qlLop:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    public void getDATA(){
        database.open();
        data.getDt().arrSV = new ArrayList<>(database.getAllData());
        database.close();
    }
}
