package com.example.ChooseData;

import android.app.Activity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MyActivity extends Activity {
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        DatePicker datePicker=(DatePicker)findViewById(R.id.datePicker);
        TimePicker timePicker=(TimePicker)findViewById(R.id.timePicker);
        Calendar c=Calendar.getInstance();
        year=c.get(Calendar.YEAR);
        month=c.get(Calendar.MONTH);
        day=c.get(Calendar.DAY_OF_MONTH);
        hour=c.get(Calendar.HOUR);
        minute=c.get(Calendar.MINUTE);
        datePicker.init(year,month,day,new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker arg0, int year, int month, int day) {
                MyActivity.this.year = year;
                MyActivity.this.month = month;
                MyActivity.this.day = day;
                showDate(year, month, day, hour, minute);
            }
        });
        timePicker.setEnabled(true);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int hourOfDay, int minute) {
                MyActivity.this.hour=hourOfDay;
                MyActivity.this.minute=minute;
                showDate(year,month,day,hour,minute);
            }
        });

        }
    private  void showDate(int year,int month,int day,int hour,int minute)
    {
        EditText show=(EditText)findViewById(R.id.show);
        show.setText("您的购买日期为"+year+"年"+(month+1)+"月"+day+"日"+hour+"时"+"" +
                minute+"分");
    }
}
