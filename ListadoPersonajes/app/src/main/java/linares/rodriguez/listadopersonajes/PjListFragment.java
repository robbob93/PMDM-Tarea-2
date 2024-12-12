package linares.rodriguez.listadopersonajes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

import linares.rodriguez.listadopersonajes.databinding.PjListFragmentBinding;

/**
 * Clase PjListFragment que muestra una lista de personajes en un RecyclerView.
 * Carga los datos de los personajes y los muestra utilizando un adaptador.
 */
public class PjListFragment extends Fragment {

    private PjListFragmentBinding binding;
    private ArrayList<PjData> personajes; // Lista de personajes a mostrar
    private PjRecyclerViewAdapter adapter; // Adaptador para el RecyclerView

    /**
     * Infla el diseño del fragmento y devuelve la vista raíz.
     *
     * @param inflater  Inflador para expandir el diseño del fragmento.
     * @param container Contenedor donde se colocará la vista del fragmento.
     * @param savedInstanceState Estado previamente guardado del fragmento, si existe.
     * @return La vista raíz inflada del fragmento.
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = PjListFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    /**
     * Método que se llama después de que la vista del fragmento ha sido creada.
     * Inicializa la lista de personajes, configura el RecyclerView y asocia el adaptador.
     *
     * @param view La vista creada para este fragmento.
     * @param savedInstanceState Estado previamente guardado del fragmento, si existe.
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Carga la lista de personajes
        loadPjs();
        // Configura el adaptador del RecyclerView
        adapter = new PjRecyclerViewAdapter(personajes, getActivity());
        binding.pjRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.pjRecyclerview.setAdapter(adapter);
    }

    /**
     * Método que carg la lista de personajes en el ArrayList.
     * Los datos incluyen la imagen, el nombre, la descripción y la habilidad de cada personaje.
     */
    private void loadPjs() {

        personajes = new ArrayList<>();

        personajes.add(new PjData(
                R.drawable.mario, // ID del recurso drawable
                "Mario",
                getString(R.string.description_mario),
                getString(R.string.skill_mario)
        ));

        personajes.add(new PjData(
                R.drawable.luigi,
                "Luigi",
                getString(R.string.description_luigi),
                getString(R.string.skill_luigi)
        ));

        personajes.add(new PjData(
                R.drawable.peach,
                "Peach",
                getString(R.string.desc_peach),
                getString(R.string.skill_peach)
        ));

        personajes.add(new PjData(
                R.drawable.toad,
                "Toad",
                getString(R.string.desc_toad),
                getString(R.string.skill_toad)
        ));

    }
}
