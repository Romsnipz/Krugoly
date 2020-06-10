package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class RegMain extends AppCompatActivity {

    private EditText editTextTextEmailAddress;
    private EditText editTextNick;
    private EditText editTextTextPassword;
    private Button button2;
    private Button button3;
    private Button button4;
    private Switch switch1;

    boolean flag = true;

    Bundle savedInstanceState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.savedInstanceState = savedInstanceState;
        setContentView(R.layout.reg_activity);

        editTextTextEmailAddress = (EditText) findViewById(R.id.editTextTextEmailAddress);
        editTextNick = (EditText) findViewById(R.id.editTextNick);
        editTextNick.setVisibility(View.GONE);
        editTextTextPassword = (EditText) findViewById(R.id.editTextTextPassword);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        switch1 = (Switch) findViewById(R.id.switch1);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegMain.this, MainActivity.class);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegMain.this, MainActivity.class);
                startActivity(intent);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag) {
                    editTextNick.setVisibility(View.VISIBLE);
                    flag = false;
                } else {
                    editTextNick.setVisibility(View.GONE);
                    flag = true;
                }
            }
        });

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    editTextTextPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                } else {
                    editTextTextPassword.setInputType(InputType.TYPE_CLASS_TEXT |
                            InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.reg_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.action_settings1:
                Intent intent = new Intent(RegMain.this, MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_settings2:
                finish();
                System.exit(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
