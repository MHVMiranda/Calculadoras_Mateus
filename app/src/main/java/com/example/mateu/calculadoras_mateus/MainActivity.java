package com.example.mateu.calculadoras_mateus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

        public void onClickCalculadoraTime(View v){
            Intent iTime = new Intent(this, CalculadoraTimeActivity.class);
            iTime.putExtra("Time", true);
            startActivity(iTime);
    }
        public void onClickCalculadoraSimples(View v){
            Intent iSimples = new Intent(this, CalculadoraSimplesActivity.class);
            iSimples.putExtra("Simples", true);
            startActivity(iSimples);
        }
        public void onClickCalculadoraUsual(View v){
            Intent iUsual = new Intent(this, CalculadoraUsualActivity.class);
            iUsual.putExtra("Usual", true);
            startActivity(iUsual);
        }

}
