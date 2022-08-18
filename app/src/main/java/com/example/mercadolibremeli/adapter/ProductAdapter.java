package com.example.mercadolibremeli.adapter;

import android.content.Context;
import android.content.Intent;
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
import com.example.mercadolibremeli.model.entities.Product;
import com.example.mercadolibremeli.view.product.ProductDetail;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private ArrayList<Product> productModelImpList;
    private Context context;

    public ProductAdapter(ArrayList<Product> productos, Context context){
        this.productModelImpList = productos;
        this.context = context;
    }
    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item_list,null,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product p = productModelImpList.get(position);
        holder.txtnombre.setText(p.getTitle());
        holder.txtprecio.setText(String.valueOf(new DecimalFormat("###,###,###").format(p.getPrice())));
        holder.txtcantidad.setText(String.valueOf(p.getAvailable_quantity()));
        Glide.with(context).load(p.getThumbnail().replaceFirst("http","https"))
                .centerCrop()
                .thumbnail(0.5f)
                .diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.img);
        holder.itemView.setOnClickListener(view -> {
            Intent a = new Intent(this.context, ProductDetail.class);
            a.putExtra("img",p.getThumbnail());
            a.putExtra("titulo", p.getTitle());
            a.putExtra("precio", p.getPrice());
            a.putExtra("Atributos",p.getAttributes());
            context.startActivity(a);
        });

    }

    @Override
    public int getItemCount() {
        return productModelImpList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{

        private TextView txtnombre,txtprecio,txtcantidad;
        private ImageView img;

        public ProductViewHolder(View itemView) {
            super(itemView);

            txtnombre = itemView.findViewById(R.id.txtnombre);
            txtprecio = itemView.findViewById(R.id.txtprecio);
            txtcantidad = itemView.findViewById(R.id.txtcantidad);
            img = itemView.findViewById(R.id.img);
        }
    }
}
