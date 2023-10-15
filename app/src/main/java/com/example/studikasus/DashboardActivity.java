package com.example.studikasus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class DashboardActivity extends AppCompatActivity {

    ImageButton buy,history,location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        buy = findViewById(R.id.buy);
        history = findViewById(R.id.history);
        location = findViewById(R.id.location);

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent movePage = new Intent(DashboardActivity.this, RVHandler.class);
                startActivity(movePage);
            }
        });

        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent movePage = new Intent(DashboardActivity.this, MapActivity.class);
                startActivity(movePage);
            }
        });

    }
}