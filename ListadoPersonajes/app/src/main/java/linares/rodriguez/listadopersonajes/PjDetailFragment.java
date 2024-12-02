package linares.rodriguez.listadopersonajes;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import linares.rodriguez.listadopersonajes.databinding.PjDetailFragmentBinding;

public class PjDetailFragment extends Fragment {

    private PjDetailFragmentBinding binding;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = PjDetailFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        if(getArguments() != null){
            int image = getArguments().getInt("image");
            String name = getArguments().getString("name");
            String description = getArguments().getString("description");
            String skill = getArguments().getString("skill");

            binding.pjImage.setImageResource(image);
            binding.pjName.setText(name);
            binding.pjDescription.setText(description);

            System.out.println("name: " + name);
            System.out.println("desc: " + description);
            binding.pjSkill.setText(skill);
            System.out.println("skill: " + skill);
        }
    }
//    @Override
//    public void onStart() {
//        super.onStart();
//        // Cambia el título del ActionBar
//        if (getActivity() != null) {
//            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("R.string.detalles_del_juego");
//        }
//    }
}
