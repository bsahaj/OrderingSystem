package com.sahajb.orderingsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // This class is only for selecting the user type customer or kitchen employee

        Button customerButton = (Button) findViewById(R.id.customerButton);
        Button employeeButton = (Button) findViewById(R.id.employeeButton);
        Button exitButton = (Button) findViewById(R.id.exitButton);

        customerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OrderName.class);
                Log.d("onClick: ", "customerButton clicked");
                startActivity(intent);
            }
        });

        employeeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TrialMainView.class);
                Log.d("onClick: ", "employeeButton clicked");
                startActivity(intent);

            }
        });
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });

    }


}
