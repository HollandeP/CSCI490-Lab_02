package com.example.csci370lab2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 1;
    public static final int RESPONSE_CODE = 1;
    private Button setBGButton;
    private ConstraintLayout constraintLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        constraintLayout = findViewById(R.id.mainConstraintLayout);

        setBGButton = findViewById(R.id.setBGButton);
        final Intent i = new Intent(getApplicationContext(), SelectBackground.class);


        setBGButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(i, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESPONSE_CODE){
            int imgId = data.getExtras().getInt("imgId");
            constraintLayout.setBackground(getDrawable(imgId));
        }
    }
}
