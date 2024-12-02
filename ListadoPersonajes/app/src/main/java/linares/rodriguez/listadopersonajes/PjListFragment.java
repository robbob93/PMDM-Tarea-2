package linares.rodriguez.listadopersonajes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

import linares.rodriguez.listadopersonajes.databinding.PjListFragmentBinding;

public class PjListFragment extends Fragment {

    private PjListFragmentBinding binding;
    private ArrayList<PjData> personajes;
    private PjRecyclerViewAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = PjListFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadPjs();
        adapter = new PjRecyclerViewAdapter(personajes, getActivity());
        binding.pjRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.pjRecyclerview.setAdapter(adapter);
    }

    private void loadPjs() {

        personajes = new ArrayList<PjData>();

        personajes.add(new PjData(
                R.drawable.mario, // ID del recurso drawable
                "Mario",
                "Se trata de un intrépido fontanero italiano, conocido por su valentía, optimismo y su habilidad para enfrentar cualquier desafío en su camino.",
                "Salto potenciado – Mario puede realizar un salto más alto y fuerte, lo que le permite derrotar enemigos, alcanzar plataformas lejanas o activar bloques especiales"
        ));

        personajes.add(new PjData(
                R.drawable.luigi,
                "Luigi",
                "El hermano menor de Mario. Aunque es tímido, demuestra gran coraje al enfrentarse a fantasmas y otros desafíos.",
                "Súper salto – Luigi puede saltar más alto que Mario."
        ));

        personajes.add(new PjData(
                R.drawable.peach,
                "Peach",
                "La Princesa del Reino Champiñón. Aunque suele ser rescatada, demuestra ser valiente y poderosa en algunas aventuras.",
                "Flotación – Peach puede flotar en el aire por unos segundos tras un salto."
        ));

        personajes.add(new PjData(
                R.drawable.toad,
                "Toad",
                "Un fiel habitante del Reino Champiñón, conocido por su rapidez y lealtad a la Princesa Peach.",
                "Velocidad extrema – Toad puede correr más rápido que cualquier otro personaje."
        ));

    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        if (getActivity()!= null){
//            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(("Prueba"));
//        }
//    }
}
