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

public class TortillasActivity extends AppCompatActivity {
    String[] datos;
    Button bSalir;
    Button bSiguiente;
    EditText cantidad;
    TextView total;
    Double suma=0.0;
    private RadioButton rad1;
    private RadioButton rad2;
    private RadioButton rad3;
    private RadioButton rad4;
    private RadioButton rad5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tortillas);
        Bundle extras = getIntent().getExtras();
        datos = extras.getStringArray("datos");

        cantidad=(EditText) findViewById(R.id.editText4);
        total=(TextView) findViewById(R.id.textView7);

        rad1=(RadioButton) findViewById(R.id.radioButton);
        rad2=(RadioButton) findViewById(R.id.radioButton2);
        rad3=(RadioButton) findViewById(R.id.radioButton3);
        rad4=(RadioButton) findViewById(R.id.radioButton4);
        rad5=(RadioButton) findViewById(R.id.radioButton5);

        bSalir=(Button) findViewById(R.id.button4);
        bSiguiente=(Button) findViewById(R.id.button5);
        bSalir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();

            }
        });
        bSiguiente.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                if(comprobar()==true){
                    lanzar(null);
                }
                else {
                    Toast toast1 =Toast.makeText(getApplicationContext(),"Por favor rellene todos los datos", Toast.LENGTH_SHORT);
                    toast1.show();                }
            }
        });

    }
    public boolean comprobar() {
        boolean comp = false;
        if(rad1.isChecked() || rad2.isChecked()) {
            if(rad3.isChecked() || rad4.isChecked()|| rad5.isChecked()) {
                comp = true;
                if(cantidad.getText().toString().equals("0") ||cantidad.getText().toString().length()==0 ) {
                    comp = false;
                }
            }

            }
        return comp;
    }
    public void lanzar(View view){
        Intent intent = new Intent(this,BebidasActivity.class);
        suma=calcularTotal();
        String[] lanzarDatos = new String[]{datos[0],datos[1],datos[2],suma.toString()};
        intent.putExtra("datos",lanzarDatos);

        startActivity(intent);
    }
    public double calcularTotal(){
        double devolver=0;
        int cant = Integer.parseInt(cantidad.getText().toString());

        if(rad1.isChecked()){
            devolver+=3.50;
        }
        else if(rad2.isChecked())
            devolver+=6.00;

        if(rad5.isChecked()){
            devolver+=0.80;
        }else if(rad4.isChecked()){
            devolver+=1.40;
        }else if(rad3.isChecked()){
            devolver+=2.25;
        }

        devolver*=cant;
        return devolver;
    }
}