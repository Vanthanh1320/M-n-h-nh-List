package com.example.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class GridActivity extends AppCompatActivity {

    TextView ten,gia;
    ImageView anh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        ten=findViewById(R.id.tengiay);
        gia=findViewById(R.id.giagiay);
        anh=findViewById(R.id.anh);

        Intent intent=getIntent();
       String receivedname=intent.getStringExtra("name");
        String receivedcount=intent.getStringExtra("count");
        int receivedimage=intent.getIntExtra("image",0);

        ten.setText(receivedname);
        gia.setText(receivedcount);
        anh.setImageResource(receivedimage);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}