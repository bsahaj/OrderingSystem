package com.sahajb.orderingsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class OrderName extends AppCompatActivity {

     EditText orderName;
     Button nextButton;

     public static OrderInfo info = new OrderInfo();

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_name);


        orderName = (EditText) findViewById(R.id.orderNameInput);
        nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setEnabled(true);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        //TODO: enable next button only when input is valid

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setCustomerName(orderName.getText().toString());
              // Toast.makeText(getApplicationContext(), cart.getCustomerName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(OrderName.this, MenuActivity.class);
                startActivity(intent);
            }
        });


    }
}
