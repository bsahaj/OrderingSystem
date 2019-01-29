package com.sahajb.orderingsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    private int breakfastCounter = 0;
    private int entreeCouter = 0;
    private int dessertCounter = 0;

    public static OrderInfo info = new OrderInfo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        TextView avocadoInfo = (TextView) findViewById(R.id.avocadoToastDescription); //avocado toast info
        avocadoInfo.setText("Served with two eggs and style and your choice of homemade fries, grits or fresh fruit. Lemon-Olive oil.");

        TextView padThaiInfo = (TextView) findViewById(R.id.padThaiDescription); //pad thai info
        padThaiInfo.setText("A stir-fried rice noodle dish.");

        TextView keyLimeInfo = (TextView) findViewById(R.id.keyLimeDescription);
        keyLimeInfo.setText("Key lime pie stuffed in cinnamon rolls, rolled up with white chocolate");
        //description from https://www.pillsbury.com/recipes/key-lime-pie-cinnamon-rolls/f0b51719-1c2a-4726-b48e-a199bc36d0d8

        Button addBreakfastbutton = (Button) findViewById(R.id.addBreakfastButton);
        Button addEntreeButton = (Button) findViewById(R.id.addEntreeButton);
        Button addDessertButton = (Button) findViewById(R.id.addDessertButton);
        Button doneButton = (Button) findViewById(R.id.doneButton);
        Button cancleButton = (Button) findViewById(R.id.cancelButton);

        //Toast.makeText(getApplicationContext(), orderInfo.getOrderName(), Toast.LENGTH_LONG).show();

        addBreakfastbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                breakfastCounter += 1;
                //String.format("Button clicked: %.2f", counter)
                Toast.makeText(getApplicationContext(), "Breakfast Counter: " + breakfastCounter, Toast.LENGTH_LONG).show();
            }
        });

        addEntreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entreeCouter += 1;
                Toast.makeText(getApplicationContext(), "Entree Counter: " + entreeCouter, Toast.LENGTH_LONG).show();
            }
        });

        addDessertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dessertCounter += 1;
                Toast.makeText(getApplicationContext(), "Dessert Counter: " + dessertCounter, Toast.LENGTH_LONG).show();
            }
        });

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(),"counter: " + orderInfo.getOrderName(), Toast.LENGTH_LONG).show();
               // Toast.makeText(getApplicationContext(), "DONE", Toast.LENGTH_LONG).show();
                done();
                Intent intent = new Intent(MenuActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });

        cancleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Order canceled.", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MenuActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void done(){
        info.setBreakfast(breakfastCounter);
        info.setEntree(entreeCouter);
        info.setDessert(dessertCounter);
        Toast.makeText(getApplicationContext(),"Total cost: " +  info.totalCost(), Toast.LENGTH_LONG).show();
    }

}
