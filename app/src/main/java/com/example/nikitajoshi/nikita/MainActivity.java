package com.example.nikitajoshi.nikita;

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
    private Button Login;
    private TextView Info;
    private int counter=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name=(EditText)findViewById(R.id.name);
        Password=(EditText)findViewById(R.id.password);
        Login=(Button) findViewById(R.id.login);
        Info=(TextView)findViewById(R.id.info);

        Info.setText("No.of attempts remaining:5");
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(),Password.getText().toString());
            }
        });

    }
    private void validate(String userName,String userPassword)
    {
        if((userName.equals("Admin") )&& (userPassword.equals("1234")))
        {
            Intent intent= new Intent(MainActivity.this,SecondActivity.class);
            startActivity(intent);
        }
        else
        {
            counter--;

           Info.setText("No. of attempts remaimng: "+String.valueOf(counter));
            if(counter==0)
            {
                Login.setEnabled(false);
            }
            Intent intent= new Intent(MainActivity.this,ThirdActivity.class);
            startActivity(intent);
        }
    }
}
