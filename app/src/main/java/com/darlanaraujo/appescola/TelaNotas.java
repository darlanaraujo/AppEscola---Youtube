package com.darlanaraujo.appescola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class TelaNotas extends AppCompatActivity {

    Button btnVerificar, btnVoltar;
    EditText editN1, editN2;
    TextView txtResultado;
    ImageView imgResultado;

    String status;

    InputMethodManager teclado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_notas);

        btnVerificar = findViewById(R.id.btnVerificar);
        btnVoltar = findViewById(R.id.btnVoltar);
        editN1 = findViewById(R.id.editN1);
        editN2 = findViewById(R.id.editN2);
        txtResultado = findViewById(R.id.txtResultado);
        imgResultado = findViewById(R.id.imgResultado);

        teclado = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        imgResultado.setVisibility(View.INVISIBLE);

        btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(editN1.getText().toString().trim().isEmpty() || editN2.getText().toString().trim().isEmpty()) {
                    Toast.makeText(getApplicationContext(), getText(R.string.campo_vazio), Toast.LENGTH_LONG).show();
                } else {
                    double n1 = Double.parseDouble(editN1.getText().toString());
                    double n2 = Double.parseDouble(editN2.getText().toString());

                    double soma = (n1 + n2) / 2;

                    if(soma >= 7) {
                        imgResultado.setImageResource(R.drawable.feliz);
                        status = getText(R.string.aprovado).toString();
                        Toast.makeText(getApplicationContext(), getText(R.string.aprovado), Toast.LENGTH_LONG).show();
                    } else if (soma >= 5) {
                        imgResultado.setImageResource(R.drawable.preocupado);
                        status = getText(R.string.recuperação).toString();
                        Toast.makeText(getApplicationContext(), getText(R.string.recuperação), Toast.LENGTH_LONG).show();
                    } else {
                        imgResultado.setImageResource(R.drawable.triste);
                        status = getText(R.string.reprovado).toString();
                        Toast.makeText(getApplicationContext(), getText(R.string.reprovado), Toast.LENGTH_LONG).show();
                    }

                    txtResultado.setText(String.valueOf("A MÉDIA DO ALUNO FOI: " + soma + " STATUS: " + status));

                    imgResultado.setVisibility(View.VISIBLE);
                    teclado.hideSoftInputFromWindow(editN2.getWindowToken(), 0);
                    ocultarBarraInferior();
                    limparTexto();
                }


            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        ocultarBarraInferior();

    }

    public void ocultarBarraInferior() {
        View barraInferior = getWindow().getDecorView();
        int comandos = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        barraInferior.setSystemUiVisibility(comandos);
    }

    public void limparTexto(){
        editN1.setText("");
        editN2.setText("");
    }

    public void voltar(View view) {
        finish();
    }
}