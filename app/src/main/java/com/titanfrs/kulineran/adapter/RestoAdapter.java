package com.titanfrs.kulineran.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.titanfrs.kulineran.R;
import com.titanfrs.kulineran.model.ItemRestoModel;
import java.util.List;

public class RestoAdapter extends RecyclerView.Adapter<RestoAdapter.MyHolder> {

    List<ItemRestoModel> mList;
    Context ctx;

    public RestoAdapter(Context ctx,List<ItemRestoModel> mList) {
        this.mList = mList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_list_item_f,viewGroup, false);
        final MyHolder holder = new MyHolder(layout);

//        holder.btnDetail.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(ctx,DetailTokoh.class);
//                i.putExtra("nama_ulama",mList.get(holder.getAdapterPosition()).getNama_ulama());
//                i.putExtra("tanggal_ulama",mList.get(holder.getAdapterPosition()).getTanggal_lahir());
//                i.putExtra("tempat_ulama",mList.get(holder.getAdapterPosition()).getTempat_lahir());
//                i.putExtra("link_ulama",mList.get(holder.getAdapterPosition()).getLink_gambar());
//                i.putExtra("desk",mList.get(holder.getAdapterPosition()).getDesk());
//
//                ctx.startActivity(i);
//
//            }
//        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {
        ItemRestoModel restoList = mList.get(i);
        myHolder.resto.setText(restoList.getResto());
        myHolder.alamat.setText(restoList.getAlamat());
        myHolder.phone.setText(restoList.getPhone());
        Glide.with(ctx).load(restoList.getFoto()).override(350,550).into(myHolder.foto);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }



    public class MyHolder extends RecyclerView.ViewHolder {
        TextView resto, alamat, phone;
        ImageView foto;
        Button btnDetail;
        public MyHolder(View v)
        {
            super(v);

            resto  = (TextView) v.findViewById(R.id.nama_resto);
            alamat = (TextView) v.findViewById(R.id.alamat);
            phone = (TextView) v.findViewById(R.id.phone);
            foto = (ImageView) v.findViewById(R.id.fotoresto);
            btnDetail = (Button) v.findViewById(R.id.btn_detail);

        }

    }
}

