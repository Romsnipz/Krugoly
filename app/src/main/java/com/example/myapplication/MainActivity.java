package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView3(this));
    }
}

// Шкрек проект

//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//
//public class MainActivity extends AppCompatActivity {
//
//    private EditText editText;
//    private EditText editText2;
//    private TextView textView;
//    private Button button;
//    private MyView myview;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        setContentView(R.layout.activity_main);
//        setContentView(new MyView(this));
//
//        editText  = (EditText) findViewById(R.id.editText);
//        editText2 = (EditText) findViewById(R.id.editText2);
//        textView  = (TextView) findViewById(R.id.textView);
//        button = (Button) findViewById(R.id.button);
//        myview = (MyView) findViewById(R.id.myview);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                double a,b,S;
//                String S1 = editText.getText().toString();
//                String S2 = editText2.getText().toString();
//                a = Double.parseDouble(S1);
//                b = Double.parseDouble(S2);
//                S = a+b;
//                String S3 = Double.toString(S);
//                textView.setText(S3);
//                button.setText("Хыыы Нажал, давай ещё");
//            }
//        });
//    }
//}
