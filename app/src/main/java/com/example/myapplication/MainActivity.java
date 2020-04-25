package com.example.myapplication;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    MyView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                    setContentView(getView());
                } else {
                    getView().resumk();
                }
                return true;
            case R.id.action_settings2:
                if (view != null) {
                    getView().stopk();
                }
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
