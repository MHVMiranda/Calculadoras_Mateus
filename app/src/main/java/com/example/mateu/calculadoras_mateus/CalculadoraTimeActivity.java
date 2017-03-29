package com.example.mateu.calculadoras_mateus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class CalculadoraTimeActivity extends AppCompatActivity {

    //aqui se DECLARA as variaveis
    private EditText etNome;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_time);

            //aqui se INSTANCIA/ATRIBUI VALORES as variaveis
        etNome = (EditText) findViewById(R.id.etNome);
        //r.id.editText e .textView apresentam erro!
        tvResultado = (TextView) findViewById(R.id.tvResultado);
    }
    public void onClickCalcular(View v) {
        if (!etNome.getText().toString().isEmpty()) {
            if (!etNome.getText().toString().equalsIgnoreCase("Galo") && (!etNome.getText().toString().equalsIgnoreCase("Atletico")) && (!etNome.getText().toString().equalsIgnoreCase("Atlético"))) {
                Random rand = new Random();
                int i = rand.nextInt(100);
                tvResultado.setText("As chances desse time ser campeão são de " + i + "%");
            } else {
                tvResultado.setText("Impossível!");
            }
        }
    }
    public void onClickVoltar(View v){
        super.onBackPressed();
    }


}
