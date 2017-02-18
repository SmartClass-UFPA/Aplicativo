package engcomp.smartclassufpa.View.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

import engcomp.smartclassufpa.Data.Prova;
import engcomp.smartclassufpa.R;

/**
 * Created by alberto on 29/01/2017.
 */

public class ProvasReciclerViewAdapter extends RecyclerView.Adapter<ProvasReciclerViewAdapter.CustomViewHolder> {


    private ArrayList<Prova> listaDeProvas;
    private Context mContext;


    public ProvasReciclerViewAdapter(Context context, ArrayList<Prova> listaDeProvas) {
        this.listaDeProvas = listaDeProvas;
        this.mContext = context;
    }



    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_row,parent,false);
        return new CustomViewHolder(view);
    }


    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        Prova prova = listaDeProvas.get(position);

        //capturar cada informação para adicionar ao viewholder
        holder.titulo.setText(prova.getTitulo());
        holder.disciplina.setText(prova.getDisciplina());


        if (prova.getAssuntos().size()>=1) {
            holder.assunto1.setText(prova.getAssuntos().get(0));

            if (prova.getAssuntos().size()>=2) {
                holder.assunto2.setText(prova.getAssuntos().get(1));

                if (prova.getAssuntos().size()>=3) {
                    holder.assunto3.setText(prova.getAssuntos().get(2));
                } else {
                    holder.assunto3.setVisibility(View.GONE);
                }

            } else {
                holder.assunto2.setVisibility(View.GONE);
                holder.assunto3.setVisibility(View.GONE);
            }

        } else {
            holder.assunto1.setVisibility(View.GONE);
            holder.assunto2.setVisibility(View.GONE);
            holder.assunto3.setVisibility(View.GONE);
            holder.AssuntoTitle.setText("Sem Assuntos");
        }




    }

    @Override
    public int getItemCount() {
        return listaDeProvas.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        protected TextView titulo;
        protected TextView disciplina;
        protected TextView date;
        protected TextView hora;
        protected TextView AssuntoTitle;
        protected CheckBox assunto1;
        protected CheckBox assunto2;
        protected CheckBox assunto3;




        public CustomViewHolder(View itemView) {
            super(itemView);

            this.titulo = (TextView) itemView.findViewById(R.id.tituloView);
            this.disciplina = (TextView) itemView.findViewById(R.id.DisciplinaView);
            this.date = (TextView) itemView.findViewById(R.id.DataView);
            this.hora = (TextView) itemView.findViewById(R.id.HoraView);
            this.AssuntoTitle = (TextView) itemView.findViewById(R.id.AssuntoTitle);
            this.assunto1 = (CheckBox) itemView.findViewById(R.id.CheckBox1);
            this.assunto2 = (CheckBox) itemView.findViewById(R.id.checkBox2);
            this.assunto3 = (CheckBox) itemView.findViewById(R.id.checkBox3);


        }
    }
}
