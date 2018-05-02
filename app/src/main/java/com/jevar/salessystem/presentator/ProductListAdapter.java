package com.jevar.salessystem.presentator;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.jevar.salessystem.R;
import com.jevar.salessystem.model.Product;

import java.util.List;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder> {

    public List<Product> productList;
    public Context context;

    public ProductListAdapter(Context context, List<Product> productList){
        this.productList = productList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.txtNameProd.setText(productList.get(position).getName_prod());
        holder.txtPriceProd.setText(productList.get(position).getPrice());
        holder.txtStockProd.setText(productList.get(position).getStock());

        final String prod_id = productList.get(position).prodId;

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isPressed()){
                    Toast.makeText(context, "Product selec : " + productList.get(position).getName_prod(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        /*holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(context, "Product ID : " + prod_id, Toast.LENGTH_SHORT).show();

            }
        });*/

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        View mView;

        public TextView txtNameProd;
        public TextView txtPriceProd;
        public TextView txtStockProd;

        public CheckBox checkBox;

        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            txtNameProd = (TextView) mView.findViewById(R.id.nameProdList);
            txtPriceProd = (TextView) mView.findViewById(R.id.priceProdList);
            txtStockProd = (TextView) mView.findViewById(R.id.stockProdList);

            checkBox = (CheckBox) mView.findViewById(R.id.checkBox);
        }
    }


}
