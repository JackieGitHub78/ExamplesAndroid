package mx.gob.sfa.dss.puebla.playlistdescarga.Metodos;

import android.provider.MediaStore;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import mx.gob.sfa.dss.puebla.playlistdescarga.Entidades.Auidos;
import mx.gob.sfa.dss.puebla.playlistdescarga.Interfaces.InterfaceMetodosDataBase;

/**
 * Created by dtit on 06/04/16.
 */
public class Metodos implements InterfaceMetodosDataBase {

    private Realm realm;
    private Auidos auidos1;
    private RealmConfiguration realmConfig;

    public Metodos(RealmConfiguration realmCo)
    {
        realmConfig = realmCo;
        realm = Realm.getInstance(realmConfig);
    }

    @Override
    public void addAudios(Auidos auidos) {

        realm.beginTransaction();
        auidos1 = realm.createObject(Auidos.class);
        auidos1.setIdSala(auidos.getIdSala());
        auidos1.setIdAudio(auidos.getIdAudio());
        auidos1.setIdIdioma(auidos.getIdIdioma());
        auidos1.setDescarga(auidos.getDescarga());
        auidos1.setDuracion(auidos.getDuracion());
        auidos1.setNombreAudio(auidos.getNombreAudio());
        auidos1.setUrlAudio(auidos.getUrlAudio());
        realm.commitTransaction();

    }
}
