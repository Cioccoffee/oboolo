package a4if1.insa.com.oboolo;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class AddEventActivity extends AppCompatActivity {
    private Calendar beginCalendar;
    private Calendar endCalendar;
    private EditText editDate;
    private EditText editBeginning;
    private EditText editEnd;
    private DatePickerDialog.OnDateSetListener dateListener;
    private TimePickerDialog.OnTimeSetListener beginningTimeListener;
    private TimePickerDialog.OnTimeSetListener endTimeListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editevent);

        String action = getIntent().getStringExtra("action");
        TextView text = findViewById(R.id.textAddSchedule);
        if (action.equals("edit")){
            System.out.println("Valeur : "+R.string.edit_event);
            text.setText(getString(R.string.edit_event));
        } else if (action.equals("create")){
            text.setText(getString(R.string.add_event));
        }

        setUpStringArrays();

        //Setting up the time and date picker
        beginCalendar = Calendar.getInstance();
        endCalendar = Calendar.getInstance();
        setUpDatePicker();
        setUpTimePicker();

        ((Button)findViewById(R.id.addButtonValidate)).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                    }
                }
        );
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
        menu.getItem(2).setOnMenuItemClickListener(
                new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        Intent intent = new Intent(AddEventActivity.this, SettingsActivity.class);
                        startActivity(intent);
                        return true;
                    }
                }
        );
        return true;
    }

    /**
     * Fills the expandable lists of the event activity with hardcoded
     * elements, as part of the demo.
     */
    private void setUpStringArrays(){
        List<String> type = new ArrayList<String>();
        type.add("Examen");
        type.add("Je suis dispo");
        type.add("Je suis absent");
        List<String> courses = new ArrayList<String>();
        courses.add("Maths");
        courses.add("Physique");
        courses.add("Informaitque");
        courses.add("Connaissance d'entreprise");
        List<String> frequency = new ArrayList<String>();
        frequency.add("Une fois");
        frequency.add("Chaque jour");
        frequency.add("Chaque semaine");
        frequency.add("Chaque mois");

        ArrayAdapter typeAdapter = new ArrayAdapter(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                type
        );
        typeAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        ((Spinner)findViewById(R.id.addTypeSpinner)).setAdapter(typeAdapter);
        ArrayAdapter courseAdapter = new ArrayAdapter(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                courses
        );
        courseAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        ((Spinner)findViewById(R.id.addCourseSpinner)).setAdapter(courseAdapter);
        ((Spinner)findViewById(R.id.addTypeSpinner)).setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (position==2) {
                            ((Spinner) findViewById(R.id.addCourseSpinner)).setVisibility(View.GONE);
                            ((TextView) findViewById(R.id.addCourseText)).setVisibility(View.GONE);
                        } else {
                            ((Spinner)findViewById(R.id.addCourseSpinner)).setVisibility(View.VISIBLE);
                            ((TextView)findViewById(R.id.addCourseText)).setVisibility(View.VISIBLE);
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                }
        );
        ArrayAdapter frequencyAdapter = new ArrayAdapter(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                frequency
        );
        frequencyAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        ((Spinner)findViewById(R.id.addFrequencySpinner)).setAdapter(frequencyAdapter);
    }

    /**
     * Establishes a special inputDialog which is invoked
     * upon touching the date editor.
     * It will thus force the user to properly seize a date.
     */
    private void setUpDatePicker(){
        editDate = (EditText)findViewById(R.id.addDateEdit);
        dateListener = new DatePickerDialog.OnDateSetListener(){

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                beginCalendar.set(Calendar.YEAR, year);
                endCalendar.set(Calendar.YEAR,year);
                beginCalendar.set(Calendar.MONTH, monthOfYear);
                endCalendar.set(Calendar.MONTH, monthOfYear);
                beginCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                endCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateDateLabel();
            }
        };
        editDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(AddEventActivity.this, dateListener,
                        beginCalendar.get(Calendar.YEAR),beginCalendar.get(Calendar.MONTH),
                        beginCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    /**
     * Same idea as setUpDatePicker, but this time with Time wheels to
     * pick a particular hour.
     */
    private void setUpTimePicker(){
        editBeginning = (EditText) findViewById(R.id.addBeginningEdit);
        editEnd = (EditText) findViewById(R.id.addEndEdit);

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
                new TimePickerDialog(AddEventActivity.this, beginningTimeListener, beginCalendar.get(Calendar.HOUR_OF_DAY),
                        beginCalendar.get(Calendar.MINUTE),true).show();
            }
        });
        editEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TimePickerDialog(AddEventActivity.this, endTimeListener, endCalendar.get(Calendar.HOUR_OF_DAY),
                        endCalendar.get(Calendar.MINUTE), true).show();
            }
        });
    }

    private void updateDateLabel(){
        String format = "dd/MM/yy";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.FRENCH);
        editDate.setText(sdf.format(beginCalendar.getTime()));
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
