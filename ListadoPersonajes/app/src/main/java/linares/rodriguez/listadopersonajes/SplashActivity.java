package linares.rodriguez.listadopersonajes;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    private static final int SPLASH_TIME = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.splash);
        // Usa la pantalla splash configurada en el tema
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }, SPLASH_TIME); // Duración


        // En caso de quererse utilizar una pantalla splash no custom en función de la versión
        // dado que se requiere una duración de al menos 2 segundos independientemente de la versión,
        // se utiliza el código de arriba.
//        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S){
//            setContentView(R.layout.splash);
//
//            // Usa la pantalla splash configurada en el tema
//            new Handler().postDelayed(() -> {
//                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
//                startActivity(intent);
//                finish();
//            }, SPLASH_TIME);
//        }else{
//            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
//            startActivity(intent);
//            finish();
//        }


    }
}
