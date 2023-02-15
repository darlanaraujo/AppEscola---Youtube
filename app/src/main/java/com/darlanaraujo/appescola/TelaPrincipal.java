package com.darlanaraujo.appescola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaPrincipal extends AppCompatActivity {

    Button btnNotas, btnSair;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        btnNotas = findViewById(R.id.btnNotas);
        btnSair = findViewById(R.id.btnSair);

        btnNotas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), TelaNotas.class);
                startActivity(intent);
            }
        });

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    protected void onResume() {
        super.onResume();

        // Comandoqueocultaabarradenavegação;
        View barraInferior = getWindow().getDecorView();
        int comandos = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // Ocultaabarrainferior
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY; // Faz a barra inferior aparecer por algum tempo se passar o dedo debaixo para cima na tela;
        barraInferior.setSystemUiVisibility(comandos);
    }
}