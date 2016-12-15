package example.com.cebanc_tortillas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button bSalir;
    Button bSiguiente;
    EditText nombre;
    EditText direccion;
    EditText telefono;
    String[] datos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bSalir=(Button) findViewById(R.id.button2);
        bSiguiente=(Button) findViewById(R.id.button3);
        nombre=(EditText) findViewById(R.id.editText);
        direccion=(EditText) findViewById(R.id.editText2);
        telefono=(EditText) findViewById(R.id.editText3);

        bSalir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }
        });
        bSiguiente.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (nombre.getText().toString().equals("") || direccion.getText().toString().equals("") || telefono.getText().toString().equals("") ) {
                    Toast toast1 =Toast.makeText(getApplicationContext(),"Introduzca todos los datos", Toast.LENGTH_SHORT);
                    toast1.show();

                } else {
                    if(telefono.getText().toString().length()<9) {
                        Toast toast2 =Toast.makeText(getApplicationContext(),"Introduzca un numero correcto", Toast.LENGTH_SHORT);
                        toast2.show();

                    }
                    else{
                        lanzar(null);
                    }
                }
            }
        });
    }

    public void lanzar(View view){
        Intent intent = new Intent(this,TortillasActivity.class);
        datos = new String[]{nombre.getText().toString(),direccion.getText().toString(),telefono.getText().toString()};
        intent.putExtra("datos",datos);

        startActivity(intent);
    }
}