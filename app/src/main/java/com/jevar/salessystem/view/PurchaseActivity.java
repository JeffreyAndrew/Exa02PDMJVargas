package com.jevar.salessystem.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.jevar.salessystem.R;
import com.jevar.salessystem.model.Product;
import com.jevar.salessystem.presentator.ProductListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PurchaseActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "FIreLog";
    private RecyclerView prodList;
    private FirebaseFirestore mFirestore;

    private ProductListAdapter productListAdapter;
    private List<Product> productList;

    private Button btnSelCompra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        productList = new ArrayList<>();
        productListAdapter = new ProductListAdapter(getApplicationContext(), productList);

        prodList = (RecyclerView) findViewById(R.id.listProdPurchase);
        prodList.setHasFixedSize(true);
        prodList.setLayoutManager(new LinearLayoutManager(this));
        prodList.setAdapter(productListAdapter);

        btnSelCompra = (Button) findViewById(R.id.btnSelCompra);
        btnSelCompra.setOnClickListener(this);


        mFirestore = FirebaseFirestore.getInstance();
        mFirestore.collection("Product").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                if (e != null){
                    Log.d(TAG, "Error: " + e.getMessage());
                }
                for(DocumentChange doc : documentSnapshots.getDocumentChanges()){
                    if (doc.getType() == DocumentChange.Type.ADDED){

                        String prodId = doc.getDocument().getId();

                        Product products = doc.getDocument().toObject(Product.class).withId(prodId);
                        productList.add(products);
                        productListAdapter.notifyDataSetChanged();
                    }
                }
                /*for (DocumentSnapshot doc : documentSnapshots){
                    String nameProd = doc.getString("name_prod");
                    Log.d(TAG, "Nombre del producto: " + nameProd);
                }*/
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSelCompra:


                Map<String, Object > prodMap = new HashMap<>();
                prodMap.put("name_prod", "1");
                prodMap.put("price", "1");
                prodMap.put("stock", "1");

                mFirestore.collection("DetalleVenta").add(prodMap).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {

                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(PurchaseActivity.this, "Venta Generada", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        String error = e.getMessage();
                        Toast.makeText(PurchaseActivity.this, "Error" +error, Toast.LENGTH_SHORT).show();
                    }
                });
                /*Intent intent = new Intent(this, SaleActivity.class);
                String[] myList = new String[]{"test1","Test2","Test3"};
                intent.putExtra("datos" , myList);*/

                //intent.putExtra("name_prod", productList.get(1).getName_prod());
                //startActivity(intent);
                Toast.makeText(this, "Presente", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
