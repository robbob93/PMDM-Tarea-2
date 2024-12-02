package linares.rodriguez.listadopersonajes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;

import linares.rodriguez.listadopersonajes.databinding.PjCardviewBinding;

public class PjRecyclerViewAdapter extends RecyclerView.Adapter<PjViewHolder> {
    private final ArrayList<PjData> personajes;
    private final Context context;

    public PjRecyclerViewAdapter(ArrayList<PjData> personajes, Context context) {
        this.personajes = personajes;
        this.context = context;
    }

    @NonNull
    @Override
    public PjViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PjCardviewBinding binding = PjCardviewBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false
        );
        return new PjViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PjViewHolder holder, int position) {
        PjData currentPj = this.personajes.get(position);
        holder.bind(currentPj);

        holder.itemView.setOnClickListener(view -> itemClicked(currentPj, view));
    }

    @Override
    public int getItemCount() {
        return personajes.size();
    }


    private void itemClicked(PjData currentPj, View view){
        ((MainActivity) context).pjClicked(currentPj, view);
        System.out.println("item clicado: " + currentPj.getName());
    }

}
