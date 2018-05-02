package com.jevar.salessystem.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.jevar.salessystem.R;
import com.jevar.salessystem.model.Product;

import java.util.ArrayList;

public class SaleActivity extends AppCompatActivity {

    ArrayList<Product> listProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale);

//        addToList();
    }

    public void addToList(){
        Intent intent = getIntent();
        //String namePrd = intent.getStringArrayExtra("datos");
       // String namePrd = intent.getStringExtra("name_prod");
        String[] myList = intent.getStringArrayExtra("datos");

/*
        for (int i = 0; i <= 20; i++) {

            Toast.makeText(this, myList[i].toString(), Toast.LENGTH_SHORT).show();

        }*/

    }
}
