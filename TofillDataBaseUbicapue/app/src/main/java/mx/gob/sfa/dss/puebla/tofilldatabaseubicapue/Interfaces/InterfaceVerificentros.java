package mx.gob.sfa.dss.puebla.tofilldatabaseubicapue.Interfaces;

import java.util.List;

import mx.gob.sfa.dss.puebla.tofilldatabaseubicapue.Entidades.Registro_civil;
import mx.gob.sfa.dss.puebla.tofilldatabaseubicapue.Entidades.Verificentros;
import retrofit.Call;
import retrofit.http.POST;

/**
 * Created by dtit on 11/03/16.
 */
public interface InterfaceVerificentros {
    @POST("wsVerificentros.php")
    Call<List<Verificentros>> verificentros();
}
