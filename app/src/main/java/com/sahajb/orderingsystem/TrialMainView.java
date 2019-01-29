/*
* FOR TESTING
* */

package com.sahajb.orderingsystem;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class TrialMainView extends AppCompatActivity {

    //a list to store all the products
    //initializing the productlist
   public List<Product> productList = new ArrayList<>();

   private ProductAdapter productAdapter;

    //the recyclerview
    RecyclerView recyclerView;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mRef = firebaseDatabase.getReference("OrdersPlaced");
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trial_main_view);

        //getting the recyclerview from xml

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                String name = dataSnapshot.child("Customer Name").getValue().toString();
                String breakfast = dataSnapshot.child("Breakfast").getValue().toString();
                String entree = dataSnapshot.child("Entree").getValue().toString();
                String dessert = dataSnapshot.child("Dessert").getValue().toString();

                //Product values = new Product(name, breakfast, entree, dessert);

                productList.add(new Product("Name: " + name, "Breakfast: " + breakfast, "Entree: " + entree, "Dessert: " + dessert));

                //Toast.makeText(getApplicationContext(), "ProductList size: " + productList.size(), Toast.LENGTH_SHORT).show();

                //creating recyclerview adapter
                adapter = new ProductAdapter(TrialMainView.this, productList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                finish();
                startActivity(getIntent());
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });



    }

    public void met(Context context){
        Toast.makeText(context, "ProductList size: " + productList.size(), Toast.LENGTH_SHORT).show();
    }
    private String str;

    public void meet(){

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                str = dataSnapshot.child("Customer Name:").getValue().toString();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
    }

}

