package com.jevar.salessystem.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.jevar.salessystem.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btnGoPurchase, btnGoRegisterProd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGoPurchase = (ImageButton) findViewById(R.id.btnPurchaseMain);
        btnGoRegisterProd = (ImageButton) findViewById(R.id.btnRegisterProdMain);

        btnGoPurchase.setOnClickListener(this);
        btnGoRegisterProd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnRegisterProdMain:
                startActivity(new Intent(this, RegisterProductActivity.class));
                break;
            case R.id.btnPurchaseMain:
                startActivity(new Intent(this, PurchaseActivity.class));
                break;
        }

    }



}
