package com.mahao.leshan.register;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.Toast;

import com.mahao.leshan.R;

import java.sql.Date;
import java.text.DateFormat;

public class DatePicker extends AppCompatActivity {

    private CalendarView calendarView;
    private String  mydate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);
        calendarView = findViewById(R.id.calendarView);
        long date = calendarView.getDate();


        mydate= String.valueOf(new Date(date));

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView arg0, int year, int month,
                                            int date) {

                month=month+1;
                Toast.makeText(getApplicationContext(),year+"-"+month+"-"+date,Toast.LENGTH_SHORT).show();

                mydate=year+"-"+month+"-"+date;
            }
        });
    }

    public void returnDate(View view) {

        Intent returnIntent = new Intent();
        returnIntent.putExtra("date", mydate);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }


}