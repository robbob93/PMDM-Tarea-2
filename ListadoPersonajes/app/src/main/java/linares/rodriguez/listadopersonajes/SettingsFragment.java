package linares.rodriguez.listadopersonajes;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreference;
import androidx.preference.SwitchPreferenceCompat;

import java.util.Locale;
import android.content.res.Configuration;
import android.content.res.Resources;



public class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);

        SwitchPreferenceCompat languagePreference = findPreference("language_preference");

        if (languagePreference != null){
            languagePreference.setOnPreferenceChangeListener((preference, newValue) -> {
                boolean isEnglish = (boolean) newValue;
                setLocale(isEnglish ? "en" : "es");
                return true;

            });
        }



    }

    private void setLocale(String language) {
    Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Resources resources = getResources();
        Configuration config = resources.getConfiguration();
        config.setLocale(locale);

        resources.updateConfiguration(config, resources.getDisplayMetrics());
        requireActivity().recreate();
    }
}