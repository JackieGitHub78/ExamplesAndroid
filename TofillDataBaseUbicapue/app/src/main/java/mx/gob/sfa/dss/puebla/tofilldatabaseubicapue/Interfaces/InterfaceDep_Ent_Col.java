package mx.gob.sfa.dss.puebla.tofilldatabaseubicapue.Interfaces;

import java.util.List;

import mx.gob.sfa.dss.puebla.tofilldatabaseubicapue.Entidades.Dep_Ent_Col;
import mx.gob.sfa.dss.puebla.tofilldatabaseubicapue.Entidades.Registro_civil;
import retrofit.Call;
import retrofit.http.POST;

/**
 * Created by dtit on 11/03/16.
 */
public interface InterfaceDep_Ent_Col {

    @POST("wsDepEn.php")
    Call<List<Dep_Ent_Col>> dep_ent_col();
}
