package com.example.mercadolibremeli.adapter;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.mercadolibremeli.R;
import com.example.mercadolibremeli.model.entities.Productos;
import com.example.mercadolibremeli.view.productos.ProductosDetail;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class AdapterProductos extends RecyclerView.Adapter<AdapterProductos.viewHolderProducto> implements Serializable {

    private ArrayList<Productos> productosArrayList;
    private Context context;

    public AdapterProductos(ArrayList<Productos> productosArrayList, Context context) {
        this.productosArrayList = productosArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolderProducto onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i("AdapterProductos", "Se infla CardView");
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item_list,null,false);
        return new viewHolderProducto(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolderProducto holder, int position) {
        Productos p = productosArrayList.get(position);
        holder.txtnombre.setText(p.getTitle());
        holder.txtprecio.setText(new DecimalFormat("###,###,###").format(p.getPrice()));
        holder.txtcantidad.setText(String.valueOf(p.getAvailable_quantity()));
        Glide.with(context).load(p.getThumbnail().replaceFirst("http","https"))
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.img);
        holder.itemView.setOnClickListener(view -> {
            Intent a = new Intent(this.context, ProductosDetail.class);
            a.putExtra("img",p.getThumbnail());
            a.putExtra("titulo", p.getTitle());
            a.putExtra("precio", p.getPrice());
            a.putExtra("Atributos",p.getAttributes());
            context.startActivity(a);
        });
    }

    @Override
    public int getItemCount() {
        return productosArrayList.size();
    }

    public class viewHolderProducto extends RecyclerView.ViewHolder {

        private TextView txtnombre,txtprecio,txtcantidad;
        private ImageView img;

        public viewHolderProducto(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            txtnombre = itemView.findViewById(R.id.txtnombre);
            txtprecio = itemView.findViewById(R.id.txtprecio);
            txtcantidad = itemView.findViewById(R.id.txtcantidad);
        }
    }
}
