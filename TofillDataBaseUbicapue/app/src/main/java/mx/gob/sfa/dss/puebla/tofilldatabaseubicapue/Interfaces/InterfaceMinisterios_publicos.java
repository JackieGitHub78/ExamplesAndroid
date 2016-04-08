package mx.gob.sfa.dss.puebla.tofilldatabaseubicapue.Interfaces;

import java.util.List;

import mx.gob.sfa.dss.puebla.tofilldatabaseubicapue.Entidades.Ministerios_publicos;
import mx.gob.sfa.dss.puebla.tofilldatabaseubicapue.Entidades.Registro_civil;
import retrofit.Call;
import retrofit.http.POST;

/**
 * Created by dtit on 11/03/16.
 */
public interface InterfaceMinisterios_publicos {
    @POST("wsMinisteriosPublicos.php")
    Call<List<Ministerios_publicos>> ministerios_publicos();
}
