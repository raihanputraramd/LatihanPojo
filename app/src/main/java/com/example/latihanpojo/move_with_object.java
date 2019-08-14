package com.example.latihanpojo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class move_with_object extends AppCompatActivity {

    public static String EXTRA_PERSON = "extra_person";
    public TextView tvObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_object);
        tvObject = (TextView)findViewById(R.id.tv_object_received);
        person mperson = getIntent().getParcelableExtra(EXTRA_PERSON);
        String text = "Name : "+mperson.getName()+"Email : "+mperson.getEmail()+"Age : "+mperson.getAge()+"Location : "+mperson.getCity();
        tvObject.setText(text);

    }
}
