package aleh.ahiyevich.recyclerviewonfragment;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class FirstFragment extends Fragment {

    RecyclerView recyclerView;
    private ArrayList<Notes> notes = new ArrayList<>();

    public static Fragment newInstance() {
        return new FirstFragment();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @RequiresApi(api = Build.VERSION_CODES.S)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);

        initRec();

        initDataNotes();


        return view;
    }

    private void initRec() {

        MyAdapter myAdapter = new MyAdapter(getContext(), notes);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(layoutManager);


        myAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                DetailsFragment.selectedNote = notes.get(position);
                
                requireActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container_for_fragment, DetailsFragment.newInstance())
                        .addToBackStack("")
                        .commit();
            }
        });

    }

    private void initDataNotes() {

        for (int i = 0; i < 3; i++) {
            notes.add(new Notes("Заметка " + (i+1) , R.drawable.b, "Описание " + (i+1)));

        }

//        notes.add(new Notes("Заметка " + notes.size()+1, R.drawable.b, "Описание " + notes.size()));
//        notes.add(new Notes("Заметка " + notes.size()+1, R.drawable.b, "Описание " + notes.size()));
//        notes.add(new Notes("Заметка " + notes.size()+1, R.drawable.b, "Описание " + notes.size()));
    }


}