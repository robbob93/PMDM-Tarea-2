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

/**
 * MainActivity es la actividad principal de la aplicación.
 * Administra la configuración de la barra de navegación, el menú lateral (NavigationDrawer)
 * y la navegación entre fragmentos. Además, gestiona la configuración del idioma.
 */
public class MainActivity extends AppCompatActivity {

    private ActionBarDrawerToggle toggle;
    private ActivityMainBinding binding;
    private NavController navController;


    /**
     * Se ejecuta al crear la actividad.
     * Configura la navegación, el menú lateral, el idioma de la aplicación, y los listeners de eventos.
     *
     * @param savedInstanceState Contiene el estado previamente guardado de la actividad, si existe.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // Recupera las preferencias del usuario (en este caso sólo el idioma)
        getPreferences();

        binding  = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Configura la barra de herramientas (Toolbar)
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Obtener el NavController desde el NavHostFragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        NavHostFragment navHostFragment = (NavHostFragment) fragmentManager.findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();

        // Configura los destinos raíz para la barra de navegación
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.mainFragment // Incluye el mainFragment como destino raíz
        ).setOpenableLayout(binding.drawerLayout).build();

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);



        // Configura el menú lateral y la navegación
        configureToggleMenu();
        configureNavigation();

        // Listener para cambiar el ícono de la barra de navegación según el fragmento actual
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

        // Muestra un Snackbar de bienvenida
        simpleSnackbar(findViewById(R.id.nav_host_fragment));


        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }


    /**
     * Configura el menú lateral (NavigationDrawer) y sincroniza su estado con el ActionBar.
     */
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

    /**
     * Configura los eventos y la navegación del menú lateral.
     * Define acciones para cada ítem del menú.
     */
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


    /**
     * Navega al fragmento de detalle de un personaje añadiendo a un bundle los datos a enviar al fragmento
     *
     * @param pj   Objeto PjData que contiene los datos del personaje.
     * @param view Vista desde la que se inició la acción.
     */
    public void pjClicked(PjData pj, View view) {
        // Crear un Bundle para pasar los datos al GameDetailFragment
        Bundle bundle = new Bundle();
        bundle.putString("name", pj.getName()); // Pasa el nombre del juego
        bundle.putInt("image", pj.getImage()); // Pasa la imagen del juego
        bundle.putString("description", pj.getDescription()); // Pasa la descripción o más datos que necesites
        bundle.putString("skill", pj.getSkill()); // Pasa la descripción o más datos que necesites
        Navigation.findNavController(view).navigate(R.id.pjDetailFragment, bundle);
    }

    /**
     * Controla la navegación hacia arriba cuando el usuario presiona la flecha atrás.
     *
     * @return {@code true} si el evento fue manejado; de lo contrario, delega a la superclase.
     */
    @Override
    public boolean onSupportNavigateUp() {
        // Si el DrawerLayout está abierto se cierra
        if (binding.drawerLayout.isDrawerOpen(binding.navView)) {
            binding.drawerLayout.closeDrawer(binding.navView);
            return true; // Indica que el evento fue consumido
        }

        // En caso contrario, maneja la navegación estándar
        return NavigationUI.navigateUp(navController, binding.drawerLayout) || super.onSupportNavigateUp();
    }

    /**
     * Muestra un Snackbar con un mensaje de bienvenida.
     *
     * @param view Vista en la que se mostrará el Snackbar.
     */
    public void simpleSnackbar(View view){
        Snackbar.make(view, R.string.welcome_to, Snackbar.LENGTH_SHORT) .show(); }


    /**
     * Infla el menú de opciones en la barra lateral.
     *
     * @param menu Menú que se va a inflar.
     * @return true si el menú se creó correctamente.
     */
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    /**
     * Maneja las acciones seleccionadas en el menú de opciones.
     *
     * @param item Elemento del menú seleccionado.
     * @return true si el evento fue manejado; de lo contrario, delega a la superclase.
     */
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

    /**
     * Recupera las preferencias del usuario, en este caso sólamente el idioma seleccionado.
     */
    public void getPreferences(){
        // Recuperar idioma guardado
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        System.out.println("Preferencias" + preferences.toString());
        boolean isEnglish = preferences.getBoolean("language_preference", false);
        setLocale(isEnglish ? "en" : "es");

    }

    /**
     * Cambia el idioma de la aplicación.
     *
     * @param languageCode Código del idioma ("en" para inglés, "es" para español).
     */
    private void setLocale(String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Resources resources = getResources();
        Configuration config = resources.getConfiguration();
        config.setLocale(locale);

        resources.updateConfiguration(config, resources.getDisplayMetrics());
    }
}