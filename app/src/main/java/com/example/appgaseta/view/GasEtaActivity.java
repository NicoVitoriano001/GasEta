package com.example.appgaseta.view;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appgaseta.R;
import com.example.appgaseta.apoio.UtilGasEta;

public class GasEtaActivity extends AppCompatActivity {

   // UtilGasEta utilGasEta = new UtilGasEta();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaseta);

        UtilGasEta.metodoNaoEstatico();

       Toast.makeText(GasEtaActivity.this, UtilGasEta.mensagem(),Toast.LENGTH_LONG).show();

    }
}
