package com.example.fragmentexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText user_name_text, password_text;
//    TextView user_name_text, password_text;


    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user_name_text = findViewById(R.id.user_name);
        password_text = findViewById(R.id.password);
        btn_login = findViewById(R.id.btn_login);


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginPassData = new Intent(LoginActivity.this, HomeActivity.class);
                String user_name = user_name_text.getText().toString();
                loginPassData.putExtra("user_name", user_name);
                Toast.makeText(LoginActivity.this, user_name, Toast.LENGTH_LONG).show();
                startActivity(loginPassData);

            }
        });

    }
}
