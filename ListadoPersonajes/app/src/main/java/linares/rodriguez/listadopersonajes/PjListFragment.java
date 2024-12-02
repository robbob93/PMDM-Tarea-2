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
                "nombre prueba 1",
                "descripcion prueba 1"

        ));
        personajes.add(new PjData(
                "nombre prueba 2",
                "descripcion prueba 2"

        ));
        personajes.add(new PjData(
                "nombre prueba 1",
                "descripcion prueba 1"

        ));
        personajes.add(new PjData(
                "nombre prueba 2",
                "descripcion prueba 2"

        ));
        personajes.add(new PjData(
                "nombre prueba 1",
                "descripcion prueba 1"

        ));
        personajes.add(new PjData(
                "nombre prueba 2",
                "descripcion prueba 2"

        ));
        personajes.add(new PjData(
                "nombre prueba 1",
                "descripcion prueba 1"

        ));
        personajes.add(new PjData(
                "nombre prueba 2",
                "descripcion prueba 2"

        ));
        personajes.add(new PjData(
                "nombre prueba 1",
                "descripcion prueba 1"

        ));
        personajes.add(new PjData(
                "nombre prueba 2",
                "descripcion prueba 2"

        ));
        personajes.add(new PjData(
                "nombre prueba 1",
                "descripcion prueba 1"

        ));
        personajes.add(new PjData(
                "nombre prueba 2",
                "descripcion prueba 2"

        ));
        personajes.add(new PjData(
                "nombre prueba 1",
                "descripcion prueba 1"

        ));
        personajes.add(new PjData(
                "nombre prueba 2",
                "descripcion prueba 2"

        ));
        personajes.add(new PjData(
                "nombre prueba 1",
                "descripcion prueba 1"

        ));
        personajes.add(new PjData(
                "nombre prueba 2",
                "descripcion prueba 2"

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
