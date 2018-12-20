package a4if1.insa.com.oboolo;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SettingsActivity extends AppCompatActivity {

    private EditText editBeginning;
    private EditText editEnd;
    private Calendar beginCalendar;
    private Calendar endCalendar;
    TimePickerDialog.OnTimeSetListener beginningTimeListener;
    TimePickerDialog.OnTimeSetListener endTimeListener;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_settings);
        beginCalendar=Calendar.getInstance();
        endCalendar=Calendar.getInstance();
        setUpTimePickers();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.top_menu_return, menu);

        menu.getItem(0).setOnMenuItemClickListener(
                new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        finish();
                        return true;
                    }
                }
        );
        menu.getItem(1).setOnMenuItemClickListener(
                new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_SHORT);
                        return true;
                    }
                }
        );
        menu.getItem(2).setVisible(false);
        return true;
    }



    /**
     * This is a copy-paste from AddEventActivity.
     * The goal is to build a time picker pop-up that meets well the time format
     * for the user without this one typing anything different from an hour.
     */
    private void setUpTimePickers(){
        editBeginning = (EditText) findViewById(R.id.settings_beginAt_editText);
        editEnd = (EditText) findViewById(R.id.settings_endAt_editText);

        beginningTimeListener = new TimePickerDialog.OnTimeSetListener(){

            @Override
            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                beginCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                beginCalendar.set(Calendar.MINUTE, minute);
                updateTimeLabel(true);
            }
        };
        endTimeListener = new TimePickerDialog.OnTimeSetListener(){
            @Override
            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute){
                endCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                endCalendar.set(Calendar.MINUTE,minute);
                updateTimeLabel(false);
            }
        };
        editBeginning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TimePickerDialog(SettingsActivity.this, beginningTimeListener, beginCalendar.get(Calendar.HOUR_OF_DAY),
                        beginCalendar.get(Calendar.MINUTE),true).show();
            }
        });
        editEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TimePickerDialog(SettingsActivity.this, endTimeListener, endCalendar.get(Calendar.HOUR_OF_DAY),
                        endCalendar.get(Calendar.MINUTE), true).show();
            }
        });
    }

    private void updateTimeLabel(boolean beginning){
        String format = "HH:mm";
        SimpleDateFormat sdf =new SimpleDateFormat(format, Locale.FRENCH);
        if (beginning){
            editBeginning.setText(sdf.format(beginCalendar.getTime()));
        } else {
            editEnd.setText(sdf.format(endCalendar.getTime()));
        }

    }
}
