package br.usjt.sin.progmulti.clientesi18;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaClientesActivity extends Activity {
    Activity activity;
    Cliente[] clientes;
    public static final String CLIENTE = "br.usjt.sin.progmulti.clientesi18.cliente";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_clientes);
        activity = this;
        final Intent intent = getIntent();
        String chave = intent.getStringExtra(MainActivity.BUSCA);
        ListView listView = findViewById(R.id.lista_clientes);
        clientes = this.busca(chave);
        ClienteAdapter adapter = new ClienteAdapter(clientes, this);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent1 = new Intent(activity, DetalheClienteActivity.class);
                intent1.putExtra(CLIENTE, clientes[i]);
                startActivity(intent1);
            }
        });

    }
    private Cliente[] busca(String chave){
        Cliente[] clientes = ClienteDAO.getClientes();

        if(chave == null || chave.length()==0){
            return clientes;
        } else {
            ArrayList<Cliente> lista = new ArrayList<>();
            for(Cliente cliente:clientes){
                if(cliente.getNome().toUpperCase().contains(chave.toUpperCase())){
                    lista.add(cliente);
                }
            }
            return lista.toArray(new Cliente[0]);
        }
    }


}












