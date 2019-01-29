package com.sahajb.orderingsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CartActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    final DatabaseReference mRef = firebaseDatabase.getReference();
    private OrderName orderName = new OrderName();
   // private OrderInfo info = new OrderInfo();
    private MenuActivity menu = new MenuActivity();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        //mDatabase = FirebaseDatabase.getInstance().getReference("OrdersPlaced");

        TextView breakfastQuantity = (TextView) findViewById(R.id.breakfastQuantity);
        TextView entreeQuantity = (TextView) findViewById(R.id.entreeQuantity);
        TextView dessertQuantity = (TextView) findViewById(R.id.dessertQuantity);
        TextView totalCost = (TextView) findViewById(R.id.totalCost);

        Button placeOrderButton = (Button) findViewById(R.id.placeOrderButton);

        String temp1 = String.valueOf(menu.info.getBreakfast());
        String temp2 = String.valueOf(menu.info.getEntree());
        String temp3 = String.valueOf(menu.info.getDessert());
        String temp4 = String.valueOf(menu.info.totalCost());

        breakfastQuantity.setText(temp1);
        entreeQuantity.setText(temp2);
        dessertQuantity.setText(temp3);
        totalCost.setText(temp4);


        placeOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //    Toast.makeText(getApplicationContext(), "Order Placed!", Toast.LENGTH_SHORT).show();
                addToDatabase();

              //  Toast.makeText(getApplicationContext(), "order count: " +mRef.push().getKey(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(CartActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });

    }

    private void addToDatabase(){
        String key = mRef.push().getKey();
        mRef.child("OrdersPlaced").child(key).child("Customer Name").setValue(orderName.info.getCustomerName());
        mRef.child("OrdersPlaced").child(key).child("Breakfast").setValue(menu.info.getBreakfast());
        mRef.child("OrdersPlaced").child(key).child("Entree").setValue(menu.info.getEntree());
        mRef.child("OrdersPlaced").child(key).child("Dessert").setValue(menu.info.getDessert());
        mRef.child("OrdersPlaced").child(key).child("TotalCost").setValue(menu.info.totalCost());
        mRef.child("OrdersPlaced").child(key).child("OrderComplete").setValue(false);
    }


}
