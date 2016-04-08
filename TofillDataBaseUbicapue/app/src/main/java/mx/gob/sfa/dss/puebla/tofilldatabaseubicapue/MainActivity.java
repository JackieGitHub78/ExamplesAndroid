package mx.gob.sfa.dss.puebla.tofilldatabaseubicapue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import mx.gob.sfa.dss.puebla.tofilldatabaseubicapue.Servicio.ServicioInfo;


public class MainActivity extends AppCompatActivity {

    private ServicioInfo servicioinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        servicioinfo = new ServicioInfo();
        final RealmConfiguration realmConfig = new RealmConfiguration.Builder(MainActivity.this).build();
        servicioinfo.getallayuntamientos(realmConfig);
        servicioinfo.getallCis(realmConfig);
        servicioinfo.getallDep_Ent_Col(realmConfig);
        servicioinfo.getallEscuelas(realmConfig);
        servicioinfo.getallHospitales(realmConfig);
        servicioinfo.getallMinisteriosPublicos(realmConfig);
        servicioinfo.getallMuseos(realmConfig);
        servicioinfo.getallNotarias(realmConfig);
        servicioinfo.getallPanteones(realmConfig);
        servicioinfo.getallPueblosMagicos(realmConfig);
        servicioinfo.getallregistrocivil(realmConfig);
        servicioinfo.getallservicios(realmConfig);
        servicioinfo.getalveerificentros(realmConfig);
    }
}
