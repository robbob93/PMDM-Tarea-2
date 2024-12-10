package linares.rodriguez.listadopersonajes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import linares.rodriguez.listadopersonajes.databinding.PjCardviewBinding;

/**
 * Adaptador para el RecyclerView que mostrará una lista de personajes.
 * Asocia los datos de los personajes con los elementos del RecyclerView.
 */
public class PjRecyclerViewAdapter extends RecyclerView.Adapter<PjViewHolder> {
    private final ArrayList<PjData> personajes;
    private final Context context; // Contexto de la actividad o fragmento donde se usa el RecyclerView

    /**
     * Constructor del adaptador.
     *
     * @param personajes Lista de objetos PjData que representan los personajes.
     * @param context Contexto en el que se ejecuta el RecyclerView.
     */
    public PjRecyclerViewAdapter(ArrayList<PjData> personajes, Context context) {
        this.personajes = personajes;
        this.context = context;
    }

    /**
     * Crea y devuelve un nuevo ViewHolder que contiene la vista para un elemento de la lista.
     *
     * @param parent El ViewGroup al que se agregará la nueva vista después de vincularla a una posición del adaptador.
     * @param viewType El tipo de vista de la nueva vista (no utilizado aquí).
     * @return Un nuevo PjViewHolder que contiene la vista inflada.
     */
    @NonNull
    @Override
    public PjViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Infla el diseño del cardview para un personaje
        PjCardviewBinding binding = PjCardviewBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false
        );
        return new PjViewHolder(binding);
    }

    /**
     * Vincula los datos de un personaje a una vista en una posición específica.
     *
     * @param holder El ViewHolder que debe actualizarse para representar el contenido del elemento en la posición dada.
     * @param position La posición del elemento dentro del adaptador de datos.
     */
    @Override
    public void onBindViewHolder(@NonNull PjViewHolder holder, int position) {
        // Obtiene los datos del personaje en la posición actual
        PjData currentPj = this.personajes.get(position);
        // Vincula los datos del personaje a la vista
        holder.bind(currentPj);
        // Configura un listener para manejar clics en el elemento
        holder.itemView.setOnClickListener(view -> itemClicked(currentPj, view));
    }

    /**
     * Devuelve el número total de elementos en la lista.
     *
     * @return El tamaño de la lista de personajes.
     */
    @Override
    public int getItemCount() {
        return personajes.size();
    }

    /**
     * Maneja el evento de clic en un elemento de la lista.
     * Llama al método {@code pjClicked} en la actividad principal para manejar la navegación.
     *
     * @param currentPj El personaje que fue seleccionado.
     * @param view La vista que fue clicada.
     */
    private void itemClicked(PjData currentPj, View view){
        ((MainActivity) context).pjClicked(currentPj, view);
    }

}
