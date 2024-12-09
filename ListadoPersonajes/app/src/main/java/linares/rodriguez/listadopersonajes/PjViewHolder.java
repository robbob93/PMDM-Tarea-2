package linares.rodriguez.listadopersonajes;

import androidx.recyclerview.widget.RecyclerView;

import linares.rodriguez.listadopersonajes.databinding.PjCardviewBinding;

public class PjViewHolder extends RecyclerView.ViewHolder {


    private final PjCardviewBinding binding;

    public PjViewHolder(PjCardviewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind (PjData pj){
        binding.image.setImageResource(pj.getImage());
        binding.pjName.setText(pj.getName());

        binding.executePendingBindings();
    }
}
