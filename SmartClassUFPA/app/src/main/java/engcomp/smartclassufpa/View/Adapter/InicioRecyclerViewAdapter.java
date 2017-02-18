package engcomp.smartclassufpa.View.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import engcomp.smartclassufpa.Data.Notificacao;
import engcomp.smartclassufpa.R;

/**
 * Created by makane on 10/02/17.
 */


public class InicioRecyclerViewAdapter extends RecyclerView.Adapter<InicioRecyclerViewAdapter.CustomViewHolder> {


    private ArrayList<Notificacao> notificacoes;//
    private Context nContext;


    public InicioRecyclerViewAdapter(Context context, ArrayList<Notificacao> notificacoes) {
        this.notificacoes = notificacoes;
        this.nContext = context;

    }



    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_row2,parent,false);
        return new CustomViewHolder(view);
    }


    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        Notificacao notificacao = notificacoes.get(position);


        holder.titulo.setText(notificacao.getTitulo());
        holder.horario.setText(notificacao.getHorario());
        holder.Estado.setText(notificacao.getEstado());
        holder.materia.setText(notificacao.getMateria());
        holder.Assunto.setText(notificacao.getAssunto());





    }

    @Override
    public int getItemCount() {
        return notificacoes.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        protected TextView titulo;
        protected TextView horario;
        protected TextView materia;
        protected TextView Assunto;
        protected TextView Estado;




        public CustomViewHolder(View itemView) {
            super(itemView);

            this.titulo = (TextView) itemView.findViewById(R.id.Titulo2);
            this.materia = (TextView) itemView.findViewById(R.id.Materia);
            this.Estado = (TextView) itemView.findViewById(R.id.Estado);
            this.horario = (TextView) itemView.findViewById(R.id.Horario);
            this.Assunto = (TextView) itemView.findViewById(R.id.Assunto);

        }
    }
}