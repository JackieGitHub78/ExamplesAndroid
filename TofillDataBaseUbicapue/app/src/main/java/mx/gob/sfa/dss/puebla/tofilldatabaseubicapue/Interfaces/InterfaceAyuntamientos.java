package mx.gob.sfa.dss.puebla.tofilldatabaseubicapue.Interfaces;

import java.util.List;

import mx.gob.sfa.dss.puebla.tofilldatabaseubicapue.Entidades.Ayuntamientos;
import mx.gob.sfa.dss.puebla.tofilldatabaseubicapue.Entidades.Registro_civil;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by dtit on 11/03/16.
 */
public interface InterfaceAyuntamientos {

    @POST("wsAyuntamientos.php")
    Call<List<Ayuntamientos>> ayuntamientos();
}
