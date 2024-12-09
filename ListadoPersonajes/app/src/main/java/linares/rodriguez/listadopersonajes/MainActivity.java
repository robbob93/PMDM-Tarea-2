package linares.rodriguez.listadopersonajes;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.preference.PreferenceManager;

import com.google.android.material.snackbar.Snackbar;


import java.util.Locale;

import linares.rodriguez.listadopersonajes.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActionBarDrawerToggle toggle;
    private ActivityMainBinding binding;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //SplashScreen.installSplashScreen(this);
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);

        getPreferences();


        binding  = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Obtener el NavController desde el NavHostFragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        NavHostFragment navHostFragment = (NavHostFragment) fragmentManager.findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.mainFragment // Incluye el mainFragment como destino raíz
        ).setOpenableLayout(binding.drawerLayout).build();

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);



        // Configurar menú toggle
        configureToggleMenu();

        // Configurar la navegación
        configureNavigation();

        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            if (destination.getId() == R.id.mainFragment) {
                // En el mainFragment, muestra la hamburguesa
                toggle.setDrawerIndicatorEnabled(true);
            } else {
                // En otros fragmentos, muestra la flecha atrás
                toggle.setDrawerIndicatorEnabled(false);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }
        });
        
        simpleSnackbar(findViewById(R.id.nav_host_fragment));


        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }


    private void configureNavigation() {
        NavigationUI.setupWithNavController(binding.navView, navController);

        // Manejar la selección de elementos del menú
        binding.navView.setNavigationItemSelectedListener(menuItem -> {
            if (menuItem.getItemId() == R.id.nav_home) {
                navController.navigate(R.id.mainFragment); // Navegar al fragmento de inicio
            } else if (menuItem.getItemId() == R.id.nav_settings) {
                navController.navigate(R.id.settingsFragment);
            }
            binding.drawerLayout.closeDrawers(); // Cerrar el menú
            return true;
        });
    }


    private void configureToggleMenu() {
        // Crear el ActionBarDrawerToggle sin anular métodos
        toggle = new ActionBarDrawerToggle(
                this,
                binding.drawerLayout,
                R.string.open_drawer,
                R.string.close_drawer
        );

        // Agregar el listener al DrawerLayout
        binding.drawerLayout.addDrawerListener(toggle);

        // Sincronizar el estado inicial del toggle
        toggle.syncState();
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
        // Si el DrawerLayout está abierto, ciérralo
        if (binding.drawerLayout.isDrawerOpen(binding.navView)) {
            binding.drawerLayout.closeDrawer(binding.navView);
            return true; // Indica que el evento fue consumido
        }

        // De lo contrario, maneja la navegación estándar
        return NavigationUI.navigateUp(navController, binding.drawerLayout) || super.onSupportNavigateUp();
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


    public void getPreferences(){
        // Recuperar idioma guardado
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        System.out.println("Preferencias" + preferences.toString());
        boolean isEnglish = preferences.getBoolean("language_preference", false);
        setLocale(isEnglish ? "en" : "es");

    }

    private void setLocale(String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Resources resources = getResources();
        Configuration config = resources.getConfiguration();
        config.setLocale(locale);

        resources.updateConfiguration(config, resources.getDisplayMetrics());
    }
}