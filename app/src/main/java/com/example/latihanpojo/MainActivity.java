package com.example.latihanpojo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Person;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.net.URI;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public Button btnMoveActivity;
    public Button btnMoveWithDataActivity;
    public Button btnMoveWithObject;
    Button btnDialNumber;
    Button btnMoveResult;
    TextView tv_result;

    private int REQUEST_CODE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMoveActivity = (Button)findViewById(R.id.btn_move_activity);
        btnMoveActivity.setOnClickListener(this);
        btnMoveWithDataActivity=(Button)findViewById(R.id.btn_move_with_data_activity);
        btnMoveWithDataActivity.setOnClickListener(this);
        btnMoveWithObject=(Button)findViewById(R.id.btn_move_activity_object);
        btnMoveWithObject.setOnClickListener(this);
        btnDialNumber=(Button)findViewById(R.id.btn_dial_number);
        btnDialNumber.setOnClickListener(this);
        btnMoveResult=(Button)findViewById(R.id.btn_move_for_result);
        btnMoveResult.setOnClickListener(this);

        tv_result = findViewById(R.id.tv_result);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_move_activity:
                Intent moveIntent = new Intent(MainActivity.this,MoveActivity.class);
                startActivity(moveIntent);
                break;
            case R.id.btn_move_with_data_activity:
                Intent moveWithDataIntent = new Intent(MainActivity.this,move_with_data.class);
                moveWithDataIntent.putExtra(move_with_data.EXTRA_NAME,"Raihan Putra Ramadhan");
                moveWithDataIntent.putExtra(move_with_data.EXTRA_AGE,"17");
                startActivity(moveWithDataIntent);
                break;
            case R.id.btn_move_activity_object:
                person mPerson =  new person();
                mPerson.setName("Raihan Putra Ramadhan");
                mPerson.setAge(24);
                mPerson.setEmail("raihanputraramd@gmail.com");
                mPerson.setCity("Bandung");
                Intent moveWithObjectIntent = new Intent(MainActivity.this,move_with_object.class);
                moveWithObjectIntent.putExtra(move_with_object.EXTRA_PERSON,mPerson);
                startActivity(moveWithObjectIntent);
                break;
            case R.id.btn_dial_number:
                String PhoneNumber = "08156210381";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + PhoneNumber));
                startActivity(dialPhoneIntent);
                break;
            case R.id.btn_move_for_result:
                Intent moveForResultIntent = new Intent(MainActivity.this,move_for_result.class);
                startActivityForResult(moveForResultIntent, REQUEST_CODE);
                break;

        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE){
            if(resultCode == move_for_result.RESULT_CODE){
                int selectedValue = data.getIntExtra(move_for_result.EXTRA_SELECTED_VALUE, 0);
                tv_result.setText(String.format("Hasil: %s", selectedValue));
            }
        }
    }
}
