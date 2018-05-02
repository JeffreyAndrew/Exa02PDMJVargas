package com.jevar.salessystem.view;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.jevar.salessystem.R;

import java.util.HashMap;
import java.util.Map;

public class RegisterProductActivity extends AppCompatActivity implements View.OnClickListener{

    private FirebaseFirestore mFirestone;

    private EditText txtNameProd, txtPriceProd, txtStockProd;
    private Button btnRegisterProd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_product);

        mFirestone = FirebaseFirestore.getInstance();

        txtNameProd = (EditText)findViewById(R.id.txtNameProdRegister);
        txtPriceProd = (EditText)findViewById(R.id.txtPriceProdRegister);
        txtStockProd = (EditText)findViewById(R.id.txtStockProdRegister);

        btnRegisterProd = (Button) findViewById(R.id.btnRegisterProd);
        btnRegisterProd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String name = txtNameProd.getText().toString();
        String price = txtPriceProd.getText().toString();
        String stock = txtStockProd.getText().toString();

        Map<String, Object > prodMap = new HashMap<>();
        prodMap.put("name_prod", name);
        prodMap.put("price", price);
        prodMap.put("stock", stock);

        mFirestone.collection("Product").add(prodMap).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(RegisterProductActivity.this, "Producto agregado Correctamente", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                String error = e.getMessage();
                Toast.makeText(RegisterProductActivity.this, "Error" +error, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
