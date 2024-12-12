package linares.rodriguez.listadopersonajes;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreferenceCompat;

import java.util.Locale;

import android.content.res.Configuration;
import android.content.res.Resources;


/**
 * Clase SettingsFragment que gestiona las preferencias de configuración de la aplicación.
 * Permite al usuario cambiar el idioma de la aplicación.
 */
public class SettingsFragment extends PreferenceFragmentCompat {

    /**
     * Configura las preferencias de usuario definidas en un archivo XML.
     * Añade un listener para manejar los cambios en las preferencias.
     *
     * @param savedInstanceState Estado previamente guardado del fragmento, si existe.
     * @param rootKey            Clave raíz utilizada para organizar las preferencias.
     */
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        // Carga las preferencias desde el archivo XML
        setPreferencesFromResource(R.xml.root_preferences, rootKey);
        // Encuentra el SwitchPreferenceCompat para el idioma
        SwitchPreferenceCompat languagePreference = findPreference("language_preference");

        if (languagePreference != null) {
            // Agrega un listener para manejar los cambios en el idioma
            languagePreference.setOnPreferenceChangeListener((preference, newValue) -> {
                boolean isEnglish = (boolean) newValue;
                setLocale(isEnglish ? "en" : "es");
                return true;
            });
        }
    }

    /**
     * Cambia el idioma de la aplicación y reinicia la actividad para aplicar los cambios.
     *
     * @param language Código del idioma al que se cambiará la aplicación (por ejemplo, "en" para inglés, "es" para español).
     */
    private void setLocale(String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        // Actualiza la configuración de recursos con el nuevo idioma
        Resources resources = getResources();
        Configuration config = resources.getConfiguration();
        config.setLocale(locale);
        // Aplica los cambios y reinicia la actividad para que el idioma se actualice
        resources.updateConfiguration(config, resources.getDisplayMetrics());
        requireActivity().recreate();
    }
}