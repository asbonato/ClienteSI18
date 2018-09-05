package br.usjt.sin.progmulti.clientesi18;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetalheClienteActivity extends Activity {
    private TextView nome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String cliente = intent.getStringExtra(ListaClientesActivity.CLIENTE);
        setContentView(R.layout.activity_detalhe_cliente);
        nome = findViewById(R.id.nome_cliente);
        nome.setText(cliente);
    }
}
