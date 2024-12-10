package linares.rodriguez.listadopersonajes;

import androidx.recyclerview.widget.RecyclerView;
import linares.rodriguez.listadopersonajes.databinding.PjCardviewBinding;

/**
 * Clase PjViewHolder que representa un elemento individual del RecyclerView.
 * Contiene las vistas necesarias para mostrar los datos de un personaje y permite vincularlos.
 */
public class PjViewHolder extends RecyclerView.ViewHolder {

    private final PjCardviewBinding binding; // Enlace de las vistas del diseño del cardview

    /**
     * Constructor de la clase PjViewHolder.
     *
     * @param binding Objeto PjCardviewBinding que permite acceder a las vistas del cardview.
     */
    public PjViewHolder(PjCardviewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    /**
     * Vincula los datos de un objeto PjData con las vistas del cardview.
     *
     * @param pj Objeto PjData que contiene la información del personaje (imagen y nombre).
     */
    public void bind (PjData pj){
        // Configura la imagen del personaje
        binding.image.setImageResource(pj.getImage());
        // Configura el nombre del personaje
        binding.pjName.setText(pj.getName());
        // Ejecuta las vinculaciones pendientes
        binding.executePendingBindings();
    }
}
