package com.sahajb.orderingsystem;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import java.util.List;



public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;
    private int counter=0;

    //storing all the products in a list
    private List<Product> productList;


    private TrialMainView trilObj = new TrialMainView();

    //getting the context and product list with constructor
    public ProductAdapter(Context mCtx, List<Product> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_products, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        //getting the product of the specified position
        Product product = productList.get(position);

        //binding the data with the viewholder views
        holder.textViewName.setText(product.getName());
        holder.textViewBreakfast.setText(product.getBreakfast());
        holder.textViewEntree.setText(String.valueOf(product.getEntree()));
        holder.textViewDessert.setText(String.valueOf(product.getDessert()));

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName, textViewBreakfast, textViewEntree, textViewDessert;
        Button completeButton;

        public ProductViewHolder(final View itemView) {
            super(itemView);

            itemView.setId(counter);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewBreakfast = itemView.findViewById(R.id.textViewBreakfast);
            textViewEntree = itemView.findViewById(R.id.textViewEntree);
            textViewDessert = itemView.findViewById(R.id.textViewDessert);
            completeButton = itemView.findViewById(R.id.completeButton);

            completeButton.setId(counter);
            counter++;


            completeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    trilObj.meet();
                }
            });

        }

    }

    private void removeItem(int position) {
        productList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, productList.size());
    }

}