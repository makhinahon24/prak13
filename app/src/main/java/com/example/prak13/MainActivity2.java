package com.example.prak13;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    EditText dateTxt, timeTxt;
    ImageButton dateBtn, timeBtn;
    Button applyBtn, nailBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        dateTxt = findViewById(R.id.date_txt);
        timeTxt = findViewById(R.id.time_txt);
        dateBtn = findViewById(R.id.date_pick_btn);
        timeBtn = findViewById(R.id.time_pick_btn);
        applyBtn = findViewById(R.id.apply_btn);
        nailBtn = findViewById(R.id.nail_btn);




        dateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int year = 2023;
                int month = 8;
                int day = 20;


                DatePickerDialog.OnDateSetListener datePick = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                        dateTxt.setText(""+i2+"-"+(i1+1)+"-"+i);
                    }
                };

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity2.this, datePick, year, month, day);
                datePickerDialog.show();
            }
        });


        timeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int hours = 10;
                int minute = 12;
                boolean is24Foramt = true;


                TimePickerDialog.OnTimeSetListener timePick = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {

                        timeTxt.setText(i+":"+i1);
                    }
                };

                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity2.this, timePick, hours, minute, is24Foramt);
                timePickerDialog.show();
            }
        });


        applyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);
                builder.setTitle("Зай, выбрала нужное время?").setMessage("Ты уверена?").setIcon(R.drawable.ic_love)
                        .setPositiveButton("Летс гооооу", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();

                                Toast.makeText(MainActivity2.this, "Это успех, девочка моя!!!!", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Пойду на ноготочки", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                dialogInterface.dismiss();
                            }
                        })
                        .create();
                builder.show();
            }
        });
        nailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}