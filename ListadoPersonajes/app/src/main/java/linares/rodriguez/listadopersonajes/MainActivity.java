package linares.rodriguez.listadopersonajes;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
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
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;


import linares.rodriguez.listadopersonajes.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);

        ActivityMainBinding binding  = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController);

//        if (toolbar != null){
//            toolbar.setTitle("Titulo");
//            toolbar.setSubtitle("Subtitulo");
//        }
        simpleSnackbar(findViewById(R.id.nav_host_fragment));
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

    public void simpleSnackbar(View view){
        Snackbar.make(view, R.string.welcome_to, Snackbar.LENGTH_SHORT) .show(); }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_about) {
            new AlertDialog.Builder(this)
                    .setTitle(R.string.about_label)
                    .setMessage(R.string.dialog_message_about)
                    .setPositiveButton(R.string.close_button_text, null)
                    .show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}