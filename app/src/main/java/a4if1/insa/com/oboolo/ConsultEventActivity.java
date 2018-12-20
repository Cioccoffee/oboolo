package a4if1.insa.com.oboolo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class ConsultEventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultevent);
        setUpButtons();
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
}
