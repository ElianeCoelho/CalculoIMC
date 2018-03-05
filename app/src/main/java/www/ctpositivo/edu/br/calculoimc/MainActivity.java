package www.ctpositivo.edu.br.calculoimc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import java.util.Locale;



public class MainActivity extends AppCompatActivity {

    double valorAltura = 0;
    double valorPeso = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar sbAltura = findViewById(R.id.sbAltura);
        SeekBar sbPeso = findViewById(R.id.sbPeso);
        final TextView txtAltura = findViewById(R.id.txtAltura);
        final TextView txtPeso = findViewById(R.id.txtPeso);
        final TextView txtResultado = findViewById(R.id.txtResultado);
        Button btnCalcular = findViewById(R.id.btnCalculo);

        sbPeso.setMax(180);
        sbAltura.setMax(100);


        sbAltura.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                valorAltura = i + 130;
                String alt = valorAltura + " m";
                txtAltura.setText(alt);
            }




            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        sbPeso.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                valorPeso = i + 20;
                String peso = valorPeso + " kg";
                txtPeso.setText(peso);
            }




            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });




        btnCalcular.setOnClickListener(new  View.OnClickListener(){
            @Override
            public void onClick(View view){

             double p = valorPeso * 100;
             double a = valorAltura * valorAltura;
             double r = (p / a ) * 100;
                String texto = "";

                if(r<17){
                    texto = "Você está muito abaixo do peso";
                }else if (r>=17 &&r<18.49){
                    texto = "Você está abaixo do peso";
                }else if(r>=18.5&& r<24.99){
                    texto = "Seu peso é Ideal";
                }else if(r>=25 && r < 29.99){
                    texto = "Você está acima do peso";
                }else if(r>=30 && r < 34.99) {
                    texto = "Obeso grau I";
                }else if(r>=35 && r < 39.99) {
                    texto = "Obeso grau II";
                }else if(r>=40) {
                    texto = "Obeso grau III";
                }
                txtResultado.setText(texto);
            }
        });


    }

}
