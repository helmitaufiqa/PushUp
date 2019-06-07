package com.example.testapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.testapp.R;
import com.example.testapp.model.ModelMahasiswa;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


    private Context context;
    private List<ModelMahasiswa> mahasiswa;

    public RecyclerViewAdapter(Context context, List<ModelMahasiswa> mahasiswa) {
        this.context = context;
        this.mahasiswa = mahasiswa;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(context).inflate(R.layout.item_view,viewGroup,false);
        MyViewHolder myViewHolder = new MyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder myViewHolder, int position) {

        myViewHolder.tvNim.setText(mahasiswa.get(position).getNim());
        myViewHolder.tvNama.setText(mahasiswa.get(position).getNama());
        myViewHolder.tvJurusan.setText(mahasiswa.get(position).getJurusan());
        myViewHolder.tvJk.setText(mahasiswa.get(position).getJk());


    }

    @Override
    public int getItemCount() {
        return mahasiswa.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.tvNim)
        TextView tvNim;
        @BindView(R.id.tvNama)
        TextView tvNama;
        @BindView(R.id.tvJurusan)
        TextView tvJurusan;
        @BindView(R.id.tvJk)
        TextView tvJk;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }


}
