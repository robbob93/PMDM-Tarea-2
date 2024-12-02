package linares.rodriguez.listadopersonajes;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;


import linares.rodriguez.listadopersonajes.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        ActivityMainBinding binding  = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        //NavigationUI.setupActionBarWithNavController(this, navController);

    }


    public void pjClicked(PjData pj, View view) {
        // Crear un Bundle para pasar los datos al GameDetailFragment
        Bundle bundle = new Bundle();
        bundle.putString("name", pj.getName()); // Pasa el nombre del juego


        bundle.putInt("image", pj.getImage()); // Pasa la imagen del juego
        bundle.putString("description", pj.getDescription()); // Pasa la descripción o más datos que necesites
        bundle.putString("skill", pj.getSkill()); // Pasa la descripción o más datos que necesites
        Navigation.findNavController(view).navigate(R.id.pjDetailFragment, bundle);
    }

    @Override
    public boolean onSupportNavigateUp() {
        // Utiliza el método navigateUp del NavController
        return navController.navigateUp() || super.onSupportNavigateUp();
    }
}