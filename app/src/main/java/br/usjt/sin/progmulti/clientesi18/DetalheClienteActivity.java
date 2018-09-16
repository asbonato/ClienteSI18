package br.usjt.sin.progmulti.clientesi18;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalheClienteActivity extends Activity {
    private TextView nome, fone, email;
    private ImageView foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_cliente);
        nome = findViewById(R.id.detalhe_txt_nome);
        fone = findViewById(R.id.detalhe_txt_fone);
        email = findViewById(R.id.detalhe_txt_email);
        foto = findViewById(R.id.detalhe_foto_cliente);

        Intent intent = getIntent();
        Cliente cliente = (Cliente)intent.getSerializableExtra(ListaClientesActivity.CLIENTE);
        nome.setText(cliente.getNome().toString());
        fone.setText(cliente.getFone().toString());
        email.setText(cliente.getEmail().toString());
        foto.setImageDrawable(Util.getImagem(this, cliente.getFoto()));
    }
}