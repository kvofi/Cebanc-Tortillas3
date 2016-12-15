package example.com.cebanc_tortillas;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class BebidasActivity extends AppCompatActivity {
    String[] datos;
    Button bSalir;
    Button bSiguiente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bebidas);
        Bundle extras = getIntent().getExtras();
        datos = extras.getStringArray("datos");

        bSalir=(Button) findViewById(R.id.button2);
        bSiguiente=(Button) findViewById(R.id.button3);
        bSalir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();

            }
        });
        bSiguiente.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast toast1 =Toast.makeText(getApplicationContext(),datos[3]+"€", Toast.LENGTH_SHORT);
                toast1.show();
            }
        });

    }

}