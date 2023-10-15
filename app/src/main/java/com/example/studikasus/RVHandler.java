package com.example.studikasus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class RVHandler extends AppCompatActivity {

    ArrayList<HistoryModel> historyModels = new ArrayList<>();
    Integer[] icon = {R.drawable.baju1, R.drawable.baju2, R.drawable.shoe};
    String[] name = {"Green sweater", "Comfortable shirt", "White-blue shoes"};
    String[] date = {"02 Jan 2023", "10 Jun 2022", "23 May 2022"};
    String[] price = {"$05.25", "$02.22", "$10.00"};
    ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RVHandler.this, DashboardActivity.class);
                startActivity(i);
            }
        });

        RecyclerView rv = findViewById(R.id.recycler);

        historyModels.add(new HistoryModel(icon[0], name[0], date[0], price[0]));
        historyModels.add(new HistoryModel(icon[1], name[1], date[1], price[1]));
        historyModels.add(new HistoryModel(icon[2], name[2], date[2], price[2]));

        MyAdapter adapter = new MyAdapter(this, historyModels);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);
    }
}