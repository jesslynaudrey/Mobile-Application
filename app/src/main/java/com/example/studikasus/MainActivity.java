package com.example.studikasus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText PassInput, Username;
    CheckBox ShowPass;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Username = findViewById(R.id.username);
        PassInput = findViewById(R.id.password);
        ShowPass = findViewById(R.id.showPass);
        login = findViewById(R.id.login);

        ShowPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ShowPass.isChecked()){
                    //Saat Checkbox dalam keadaan Checked, maka password akan di tampilkan
                    PassInput.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else {
                    //Jika tidak, maka password akan di sembuyikan
                    PassInput.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Username.getText().toString().equals("") || PassInput.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Please fill the username AND password!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent i = new Intent(MainActivity.this, DashboardActivity.class);;
                    i.putExtra("username", Username.getText().toString());
                    i.putExtra("password", PassInput.getText().toString());
                    startActivity(i);
                }
            }
        });
    }
}