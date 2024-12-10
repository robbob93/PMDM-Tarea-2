package linares.rodriguez.listadopersonajes;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import linares.rodriguez.listadopersonajes.databinding.PjDetailFragmentBinding;


/**
 * Clase PjDetailFragment que muestra los detalles de un personaje seleccionado.
 * Recibe datos a través de un Bundle y los utiliza para actualizar la interfaz de usuario.
 */
public class PjDetailFragment extends Fragment {

    private PjDetailFragmentBinding binding;

    /**
     * Método que infla el diseño del fragmento y devuelve la vista raíz.
     *
     * @param inflater  Inflador para expandir el diseño del fragmento.
     * @param container Contenedor donde se colocará la vista del fragmento.
     * @param savedInstanceState Estado previamente guardado del fragmento, si existe.
     * @return La vista raíz inflada del fragmento.
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = PjDetailFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    /**
     * Método que se llama después de que la vista del fragmento ha sido creada.
     * Configura los datos en la interfaz de usuario y ajusta el título del ActionBar.
     *
     * @param view La vista creada para este fragmento.
     * @param savedInstanceState Estado previamente guardado del fragmento, si existe.
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Comprueba si hay argumentos pasados al fragmento
        if(getArguments() != null){
            // Recupera los datos del personaje desde el Bundle
            int image = getArguments().getInt("image");
            String name = getArguments().getString("name");
            String description = getArguments().getString("description");
            String skill = getArguments().getString("skill");

            // Actualiza la interfaz de usuario con los datos del personaje
            binding.pjImage.setImageResource(image);
            binding.pjName.setText(name);
            binding.pjDescription.setText(description);
            binding.pjSkill.setText(skill);

            // Cambia el título del ActionBar para mostrar el nombre del personaje
            if (getActivity() != null) {
                ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.details_of) + name);
            }

            // Muestra un mensaje Toast indicando el personaje seleccionado
            Toast.makeText(getContext(),getString(R.string.choosed_pj) + name,Toast.LENGTH_LONG).show();
        }
    }
}
