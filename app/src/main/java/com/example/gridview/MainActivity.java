package com.example.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CursorAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.AdapterView.*;

public class MainActivity extends AppCompatActivity {
    GridView gridView;

    String[] name= {"MLB NEW YORK","MLB WHITE NY LOGO ĐEN","MLB HALO PINK","MLB MINT","MLB NY PURPLE","JORDAN 1 TRAVIS SCOTT"};
    String[] count = {"850.000đ","850.000đ","850.000đ","850.000đ","950.000đ","950.000đ"};

    int[] image = {R.drawable.giay1,R.drawable.giay2,R.drawable.giay3,R.drawable.giay4,R.drawable.giay5,R.drawable.giay6};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gv_giay);

        CustomAdapter customAdapter = new CustomAdapter();
        gridView.setAdapter(customAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),name[i], Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), GridActivity.class);
                intent.putExtra("name", name[i]);
                intent.putExtra("count",count[i]);
                intent.putExtra("image", image[i]);
                startActivity(intent);
            }

        });
    }

    private class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return name.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1=getLayoutInflater().inflate(R.layout.row,null);

            TextView ten=view1.findViewById(R.id.tv_ten);
            TextView gia=view1.findViewById(R.id.tv_gia);
            ImageView anh=view1.findViewById(R.id.im_hinh);

            ten.setText(name[i]);
            anh.setImageResource(image[i]);
            gia.setText(count[i]);
            return view1;
        }
    }

}