package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    MyView view;
    Bundle savedInstanceState;
    int C;
    boolean flag = true;

    private EditText editText;
    private TextView textView;
    private Button button;

    private Button button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.savedInstanceState = savedInstanceState;
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        textView  = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);

        button5 = (Button) findViewById(R.id.button5);

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag) {
                    button.setVisibility(View.GONE);
                    textView.setVisibility(View.GONE);
                    editText.setVisibility(View.GONE);
                    button5.setText(getResources().getString(R.string.sorry));
                    Toast.makeText(MainActivity.this, getText(R.string.sss),
                            Toast.LENGTH_SHORT).show();
                    flag = false;
                } else {
                    button.setVisibility(View.VISIBLE);
                    textView.setVisibility(View.VISIBLE);
                    editText.setVisibility(View.VISIBLE);
                    button5.setText(getResources().getString(R.string.s));
                    Toast.makeText(MainActivity.this, getText(R.string.yyy),
                            Toast.LENGTH_SHORT).show();
                    flag = true;
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String S = editText.getText().toString();
                if (S.equals("")) {
                    C = 5;
                } else if (Integer.parseInt(S) > 10 || Integer.parseInt(S) < 1){
                    C = 5;
                } else {
                    C = Integer.parseInt(S);
                }
                getView().setN(C);
                setContentView(getView());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.action_settings1:
                if (view == null) {
                    String S = editText.getText().toString();
                    if (S.equals("")) {
                        C = 5;
                    } else {
                        C = Integer.parseInt(S);
                    }
                    getView().setN(C);
                    setContentView(getView());
                } else {
                    getView().resumk();
                }
                return true;
            case R.id.action_settings2:
                if (view != null) {
                    getView().stopk();
                } else {
                    return true;
                }
                return true;
            case R.id.action_settings3:
                view = null;
                String S = editText.getText().toString();
                if (C == 0) {
                    return true;
                } else {
                    getView().setN(C);
                    setContentView(getView());
                }
                return true;
            case R.id.action_settings4:
                view = null;
                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_settings5:
                view = null;
                Intent intent1 = new Intent(MainActivity.this,RegMain.class);
                startActivity(intent1);
                return true;
            case R.id.action_settings6:
                finish();
                System.exit(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public MyView getView() {
        if (view == null) {
            view = new MyView(this);
        }
        return view;
    }

}
