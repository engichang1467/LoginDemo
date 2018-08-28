package com.example.samsung.logindemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 5;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText)findViewById(R.id.etName);
        Password = (EditText)findViewById(R.id.etPassword);
        Info = (TextView)findViewById(R.id.tvinfo);
        Login = (Button)findViewById(R.id.btnLogin);

        Info.setText("No. of attempts remaining: 5");

        Login.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view){
                validate(Name.getText().toString(), Password.getText().toString());
            }

        });



    }

    // Write a function that validates if our password is right/wrong
    private void validate(String userName, String userPassword){

        if((userName.equals("mikeman")) && (userPassword.equals("1234"))){

            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);  // This is how you can move to the next activity in this 2 lines

        }else{

            counter--;  // this will decrease counter by 1 every time when user enter wrong input

            Info.setText("No. of attempts remaining: " + String.valueOf(counter));

            if(counter == 0){

                Login.setEnabled(false);  //This should only works when the login button is click

            }

        }
    }
}
