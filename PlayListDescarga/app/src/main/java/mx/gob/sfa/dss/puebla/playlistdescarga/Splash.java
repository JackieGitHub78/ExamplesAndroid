package mx.gob.sfa.dss.puebla.playlistdescarga;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Space;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import mx.gob.sfa.dss.puebla.playlistdescarga.Servicios.Servicio;

public class Splash extends AppCompatActivity {

    private ProgressDialog progressDialogwait;
    Servicio servicio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        servicio = new Servicio();
        new Hiloprincipal().execute();

    }

    private  class Hiloprincipal extends AsyncTask<Void, Void, Void>
    {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialogwait = ProgressDialog.show(Splash.this, null,null,true);
            progressDialogwait.setContentView(R.layout.wait_progress_dialog);
            progressDialogwait.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            progressDialogwait.show();

        }

        @Override
        protected Void doInBackground(Void... params) {
            final RealmConfiguration realmConfig = new RealmConfiguration.Builder(Splash.this).build();
            servicio.getalsounds(Splash.this, realmConfig);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            progressDialogwait.dismiss();
        }
    }
}
