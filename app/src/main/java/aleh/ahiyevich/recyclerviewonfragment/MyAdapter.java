package aleh.ahiyevich.recyclerviewonfragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


    List<Notes> notesList;
    private OnItemClickListener onItemClickListener;


    public MyAdapter (Context context, List<Notes> list){

        notesList = list;
    }


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);

        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Notes note = notesList.get(position);

        holder.image.setImageResource(note.getImage());
        holder.tittle.setText(note.getTittle());
        holder.description.setText(note.getDescription());


    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tittle,description;
        ImageView image;

        public ViewHolder(@NonNull View view) {
            super(view);

            image = view.findViewById(R.id.image);
            tittle = view.findViewById(R.id.tittle);
            description = view.findViewById(R.id.description);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if(onItemClickListener != null){
                        onItemClickListener.onClick(view,position);
                    }
                }
            });


        }

    }
}
