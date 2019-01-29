package com.sahajb.orderingsystem;

import android.app.ActionBar;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class EmployeeActivity extends AppCompatActivity {

    private  FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mRef = firebaseDatabase.getReference("OrdersPlaced");

    private Button button;
    private RelativeLayout myLayout = null;
    private int counter, bCounter, eCounter, dCounter, textCounter = 0;
   // private int textCounter = 0;
    private String str = "";
    private ArrayList<String> customerKeys = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

         button = findViewById(R.id.firstButton);

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot d : dataSnapshot.getChildren()){
                    customerKeys.add(d.getKey());
                }

                for(int i=0; i<customerKeys.size();i++) {
                    Toast.makeText(getApplicationContext(), "Name: " + dataSnapshot.child(customerKeys.get(i)).child("Customer Name").getValue(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewCardView();
            }
        });

    }



    private void addNewCardView(){
        CardView newCard = new CardView(EmployeeActivity.this);
        RelativeLayout relativeView = new RelativeLayout(EmployeeActivity.this);

        final TextView newText = new TextView(EmployeeActivity.this);
        final TextView newBreakfastText = new TextView(EmployeeActivity.this);
        final TextView newEntreeText = new TextView(EmployeeActivity.this);
        final TextView newDessertText = new TextView(EmployeeActivity.this);
        Button newButton = new Button(EmployeeActivity.this);

        newCard.setPadding(0, 0, 0, 0);
        newCard.setId(counter);


        newButton.setText("Order Complete " + textCounter);

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                newText.setText("Name: " + snapshot.child(customerKeys.get(textCounter)).child("Customer Name").getValue());
                newBreakfastText.setText("Breakfast: " + snapshot.child(customerKeys.get(textCounter)).child("Breakfast").getValue());
                newEntreeText.setText("Breakfast: " + snapshot.child(customerKeys.get(textCounter)).child("Breakfast").getValue());
                newDessertText.setText("Breakfast: " + snapshot.child(customerKeys.get(textCounter)).child("Breakfast").getValue());
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        //have to align the breakfast, entree, dessert using below the specific ID
        newText.setId(textCounter);
        newBreakfastText.setId(bCounter);
        newEntreeText.setId(eCounter);
        newDessertText.setId(dCounter);
        newText.setPadding(0, 0, 0, 150);

        myLayout = findViewById(R.id.myLayout);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.topMargin = 15;

        counter++;
        textCounter++;
        bCounter++;
        eCounter++;
        dCounter++;

        params.addRule(RelativeLayout.BELOW, counter);
        newCard.setLayoutParams(params);

        RelativeLayout.LayoutParams buttonParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);


        buttonParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, counter);
        buttonParams.addRule(RelativeLayout.BELOW, textCounter);

        newButton.setLayoutParams(buttonParams);

        relativeView.addView(newText);
        relativeView.addView(newBreakfastText);

        relativeView.addView(newButton);
        newCard.addView(relativeView);
        myLayout.addView(newCard);
    }

}
