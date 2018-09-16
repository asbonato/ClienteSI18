package br.usjt.sin.progmulti.clientesi18;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ClienteAdapter extends BaseAdapter {
    private Cliente[] clientes;
    private Context context;

    public ClienteAdapter(Cliente[] clientes, Context context) {
        this.clientes = clientes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return clientes.length;
    }

    @Override
    public Object getItem(int i) {
        return clientes[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View linha = view;
        if(linha == null) {
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            linha = inflater.inflate(R.layout.linha_cliente, viewGroup, false);
            ImageView foto = linha.findViewById(R.id.foto_cliente);
            TextView linha_nome = linha.findViewById(R.id.linha_nome);
            TextView linha_detalhe = linha.findViewById(R.id.linha_detalhe);
            ViewHolder holder = new ViewHolder(foto, linha_nome, linha_detalhe);
            linha.setTag(holder);
        }
        Cliente cliente = clientes[i];
        ViewHolder holder = (ViewHolder)linha.getTag();

        holder.getLinha1().setText(cliente.getNome());
        holder.getLinha2().setText(cliente.getFone() + " - " + cliente.getEmail());

        Drawable figura = Util.getImagem(context, cliente.getFoto());

        holder.getImagem().setImageDrawable(figura);

        return linha;
    }
}
