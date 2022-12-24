package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.volleyapi.R;

import java.util.ArrayList;

import Models.Producto;

public class ProductoAdaptador extends ArrayAdapter<Producto> {

    public ProductoAdaptador(Context context, ArrayList<Producto> datos) {
        super(context, R.layout.lydatos, datos);
    }

    TextView id, descripcion, costo, p_categoria;

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lydatos, null);

        id = (TextView)item.findViewById(R.id.txtId);
        id.setText(getItem(position).getId());

        descripcion = (TextView)item.findViewById(R.id.txtDes);
        descripcion.setText(getItem(position).getDescripcion());

        costo = (TextView)item.findViewById(R.id.txtCosto);
        costo.setText(getItem(position).getCosto());

        p_categoria = (TextView)item.findViewById(R.id.txtPcategoria);
        p_categoria.setText(getItem(position).getP_categoria());

        return(item);
    }
}