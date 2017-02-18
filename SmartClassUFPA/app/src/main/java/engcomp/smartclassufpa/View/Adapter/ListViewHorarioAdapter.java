package engcomp.smartclassufpa.View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import engcomp.smartclassufpa.R;
import engcomp.smartclassufpa.Data.Horario;

/**
 * Created by root on 2/11/17.
 */

public class ListViewHorarioAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Horario>mData = new ArrayList<Horario>();
    private LayoutInflater minflater;

    public ListViewHorarioAdapter(Context context) {
        minflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void addHorarios (ArrayList<Horario> getSemana) {
        mData = getSemana;
        notifyDataSetChanged();
    }

    public void addItem (Horario horario) {
        mData.add(horario);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {

        return mData.size();
    }

    @Override
    public Horario getItem(int position) {

        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {

        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();

        if (convertView == null) {
            convertView = minflater.inflate(R.layout.item_semana_aula, null);

            holder.horario = (TextView) convertView.findViewById(R.id.horario_textView);
            holder.materia = (TextView) convertView.findViewById(R.id.materia_textView);
            holder.professor = (TextView) convertView.findViewById(R.id.professor_textView);

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.horario.setText(mData.get(position).getHorario());
        holder.materia.setText(mData.get(position).getMateria());
        holder.professor.setText(mData.get(position).getProfessor());

        return convertView;
    }

    public static class ViewHolder {
        public TextView horario;
        public TextView materia;
        public TextView professor;
    }



}
