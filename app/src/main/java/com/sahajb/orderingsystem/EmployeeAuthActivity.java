package com.sahajb.orderingsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EmployeeAuthActivity extends AppCompatActivity {

    private  boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_auth);


        EditText employeeAuthPin = (EditText) findViewById(R.id.authText);
        Button authButton = (Button) findViewById(R.id.authButton);
        String authPin = employeeAuthPin.getText().toString();

        //TODO: create authentication for employess and maybe employee code

            authButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        Intent intent = new Intent(EmployeeAuthActivity.this, MenuActivity.class);
                        startActivity(intent);
                }
            });




    }


}
