package a4if1.insa.com.oboolo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.alamkanak.weekview.WeekViewEvent;

import java.util.Calendar;

public class ConsultEventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultevent);
        setUpButtons();
        long eventId = getIntent().getLongExtra("eventId",1) - 1;
        Log.v("EVENT_ID", ""+eventId);
        EventList eventList = EventList.getInstance();
        WeekViewEvent event = eventList.getEvent((int)eventId);

        int month = (event.getStartTime().get(Calendar.MONTH)+1);
        String monthStr = "";
        if(month < 10) monthStr+="0"+month;
        else
            monthStr+=month;
        String date = event.getStartTime().get(Calendar.DAY_OF_MONTH) +"/"+
                monthStr+"/"+
                event.getStartTime().get(Calendar.YEAR);
        TextView dateView = findViewById(R.id.consultDate);
        dateView.setText(date);

        int mins = event.getStartTime().get(Calendar.MINUTE);
        String minsStr = "";
        if(mins < 10) minsStr+="0"+mins;
        else
            minsStr += mins;
        String startTime = event.getStartTime().get(Calendar.HOUR_OF_DAY)+":"+
                minsStr;
        TextView startTimeView = findViewById(R.id.consultBeginning);
        startTimeView.setText(startTime);

        int mins2 = event.getEndTime().get(Calendar.MINUTE);
        String minsStr2 = "";
        if(mins < 10) minsStr2+="0"+mins2;
        else
            minsStr2 += mins2;
        String endTime = event.getEndTime().get(Calendar.HOUR_OF_DAY)+":"+
                minsStr2;
        TextView endTimeView = findViewById(R.id.consultEnd);
        endTimeView.setText(endTime);


        Event.Type type = ((Event) event).getType();
        String typestr = "";
        switch(type){
            case Examen:
                typestr = "Examen";
                break;
            case Revision:
                typestr = "Session de révision";
                break;
        }
        TextView typeView = findViewById(R.id.consultType);
        typeView.setText(typestr);

        String course = ((Event) event).getMatière();
        TextView courseView = findViewById(R.id.consultCourses);
        courseView.setText(course);



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
                        Intent intent = new Intent(ConsultEventActivity.this, SettingsActivity.class);
                        startActivity(intent);
                        return true;
                    }
                }
        );
        return true;
    }

    private void setUpButtons(){
        ((ImageButton)findViewById(R.id.consultEditButton)).setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent intent = new Intent(ConsultEventActivity.this, AddEventActivity.class);
                        intent.putExtra("action", "edit");
                        startActivity(intent);
                    }
                }
        );
        ((ImageButton)findViewById(R.id.consultDeleteButton)).setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Toast.makeText(ConsultEventActivity.this, "Efface !", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
        );
    }


    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        //String date = getIntent().getStringExtra("date");
        //TextView dateView = (TextView)findViewById(R.id.consultDate);
        //dateView.setText(date);
        return super.onCreateView(parent, name, context, attrs);
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        String date = getIntent().getStringExtra("date");
        Log.v("DATE",date);
        TextView dateView = findViewById(R.id.consultDate);
        dateView.setText(date);
    }
}
