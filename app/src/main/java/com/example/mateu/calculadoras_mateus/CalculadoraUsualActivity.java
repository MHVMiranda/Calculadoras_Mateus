package com.example.mateu.calculadoras_mateus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CalculadoraUsualActivity extends AppCompatActivity {

    private EditText et;    // declaração do edit de forma global na classe, pois, será usado em vários métodos
    private float nro1 = 0, nro2 = 0;// variáveis auxiliáres para operações da calculadora
    private char op = '0';  //variável auxiliar que armazena o operador corrente
    private boolean flagOp; // variável flag que controla quando o valor do edit deve ser iniciado

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_usual);

        //identificação do edit durante a criação da aplicação
        //o  edit que vai depois de R.id... é o que foi criado na interface
        et = (EditText) findViewById(R.id.editText2);
    }
    public void onClickVoltar(View v){
        super.onBackPressed();
    }

    //############################################################################################
    //Métodos de processamento
    //############################################################################################

    //método que é executado quando um número é acionado, preenche auxiliares e o edit
    public void clicouNumero(int numero) {

        if (op != '0') {     //se ultimo clicado foi op
            if (flagOp)      //se é necessário iniciar o edit
                et.setText("");
            flagOp = false;
            et.setText(et.getText() + "" + numero);
            nro2 = Float.parseFloat(et.getText() + "");
        } else {        // se ultimo clicado foi numero
            if (flagOp) //se é necessário iniciar o edit
                et.setText("");
            et.setText(et.getText() + "" + numero);
            nro1 = Float.parseFloat(et.getText() + "");
        }
        Log.d("[LOG_CN]", "Numero: " + nro1 + ", Op: " + op);  //envia mensagem de log no terminal
    }

    public void clicouOperador(char operador) {

        if (nro2 != 0) {    // se existir numero para fazer operação, faça
            switch (op) {   // verifica qual operador foi acionado e armazenado
                case '+':
                    nro1 = nro1 + nro2;
                    break;
                case '-':
                    nro1 = nro1 - nro2;
                    break;
                case '*':
                    nro1 = nro1 * nro2;
                    break;
                case '/':
                    if (nro2 != 0) {
                        nro1 = nro1 / nro2;
                    } else {
                        nro1 = 0;
                    }
                    break;
            }
            et.setText(nro1 + "");
            nro2 = 0;
        }
        op = operador;
        flagOp = true;
    }

    private void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    //Método de processamento para dar o resultado das operações quando o sinal de igual for acionado
    public void clicouIgual() {
        if (nro2 != 0) {    // se existir numero para fazer operação, faça
            switch (op) {   // verifica qual operador foi acionado e armazenado
                case '+':
                    nro1 = nro1 + nro2;
                    break;
                case '-':
                    nro1 = nro1 - nro2;
                    break;
                case '*':
                    nro1 = nro1 * nro2;
                    break;
                case '/':
                    if (nro2 != 0) {
                        nro1 = nro1 / nro2;
                    } else {
                        nro1 = 0;
                    }
                    break;
            }
            et.setText(nro1 + "");
            nro2 = 0;
            op = '0';
        } else {            // se não continua fazendo a operação com o resultado e o próprio resultado
            nro2 = nro1;
            switch (op) {   // verifica qual operador foi acionado e armazenado
                case '+':
                    nro1 = nro1 + nro2;
                    break;
                case '-':
                    nro1 = nro1 - nro2;
                    break;
                case '*':
                    nro1 = nro1 * nro2;
                    break;
                case '/':
                    if (nro2 != 0) {
                        nro1 = nro1 / nro2;
                    } else {
                        nro1 = 0;
                    }
                    break;
            }
            nro2 = 0;
        }
        flagOp = true;
    }

    //######################################################################################
    //Eventos de botões - INÍCIO
    //######################################################################################

    public void onClickCE(View v){
        nro2 = 0;                   //zera variáveis
        nro1 = 0;
        op = '0';
        et.setText("");
        toast("Sistema Limpo!");    //envia mensagem
    }

    public void onClick1(View v) {
        clicouNumero(1);
    }

    public void onClick2(View v) {
        clicouNumero(2);
    }

    public void onClick3(View v) {
        clicouNumero(3);
    }

    public void onClick4(View v) {
        clicouNumero(4);
    }

    public void onClick5(View v) {
        clicouNumero(5);
    }

    public void onClick6(View v) {
        clicouNumero(6);
    }

    public void onClick7(View v) {
        clicouNumero(7);
    }

    public void onClick8(View v) {
        clicouNumero(8);
    }

    public void onClick9(View v) {
        clicouNumero(9);
    }

    public void onClick0(View v) {
        clicouNumero(0);
    }

    public void onClickMais(View v) {
        clicouOperador('+');
    }

    public void onClickMenos(View v) {
        clicouOperador('-');
    }

    public void onClickMulti(View v) {
        clicouOperador('*');
    }

    public void onClickDivi(View v) {
        clicouOperador('/');
    }

    public void onClickIgual(View v) {
        clicouIgual();
    }

}
