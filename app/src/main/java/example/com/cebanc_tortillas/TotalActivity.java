package example.com.cebanc_tortillas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;



public class TotalActivity extends AppCompatActivity {
    String[] datos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total);

        Bundle extras = getIntent().getExtras();
        datos = extras.getStringArray("datos");



    }

}