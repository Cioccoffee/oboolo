package a4if1.insa.com.oboolo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class ConsultEventActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultevent);
        setUpButtons();
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
