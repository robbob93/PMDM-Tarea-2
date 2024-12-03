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

            if (getActivity() != null) {
                // Cambia el título del ActionBar
                ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.details_of) + name);
            }

            //Toast.makeText(getContext(),, Toast.LENGTH_SHORT).show();
            Toast.makeText(getContext(),getString(R.string.choosed_pj) + name,Toast.LENGTH_LONG).show();
        }
    }
}
