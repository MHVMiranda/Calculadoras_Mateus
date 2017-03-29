package com.example.mateu.calculadoras_mateus;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculadoraSimplesActivity extends AppCompatActivity {

    private EditText n1;
    private EditText n2;
    private TextView tvResultado;
    private float resultadoOperacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_simples);

        n1 = (EditText) findViewById(R.id.et1);
        n2 = (EditText) findViewById(R.id.et2);
        tvResultado = (TextView) findViewById(R.id.tvResultado);
        //o  que vai depois de R.id... é o que foi criado na interface.
        //No caso, o nome da variavel do meu primeiro campo na interface é et1, por exemplo



    }
    public void onClickSoma (View v){
        resultadoOperacao = ((Float.parseFloat(n1.getText().toString()))+ (Float.parseFloat(n2.getText().toString())));
        tvResultado.setText(resultadoOperacao+"");
        //Toast.makeText(getBaseContext(),resultadoOperacao+"",Toast.LENGTH_LONG).show();

    }
    public void onClickSubtracao (View v){
        resultadoOperacao = ((Float.parseFloat(n1.getText().toString()))- (Float.parseFloat(n2.getText().toString())));
        tvResultado.setText(resultadoOperacao+"");
        //Toast.makeText(getBaseContext(),resultadoOperacao+"",Toast.LENGTH_LONG).show();

    }
    public void onClickMultiplicacao (View v){
        resultadoOperacao = ((Float.parseFloat(n1.getText().toString()))* (Float.parseFloat(n2.getText().toString())));
        tvResultado.setText(resultadoOperacao+"");
        //Toast.makeText(getBaseContext(),resultadoOperacao+"",Toast.LENGTH_LONG).show();

    }
    public void onClickDivisao (View v) {
        if (!(Float.parseFloat(n2.getText().toString()) == 0)) {
            resultadoOperacao = ((Float.parseFloat(n1.getText().toString())) / (Float.parseFloat(n2.getText().toString())));
            tvResultado.setText(resultadoOperacao + "");
            //Toast.makeText(getBaseContext(), resultadoOperacao + "", Toast.LENGTH_LONG).show();

        }else{
            Toast.makeText(getBaseContext(), "ERRO! Divisão por 0", Toast.LENGTH_LONG).show();
            tvResultado.setText("");
            n2.setText("");
        }
    }
    public void onClickVoltar(View v){
        super.onBackPressed();
    }
    private void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
