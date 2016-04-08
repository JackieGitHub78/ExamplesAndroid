package mx.gob.sfa.dss.puebla.tofilldatabaseubicapue.Servicio;



import android.util.Log;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import mx.gob.sfa.dss.puebla.tofilldatabaseubicapue.Entidades.Ayuntamientos;
import mx.gob.sfa.dss.puebla.tofilldatabaseubicapue.Entidades.Cis;
import mx.gob.sfa.dss.puebla.tofilldatabaseubicapue.Entidades.Dep_Ent_Col;
import mx.gob.sfa.dss.puebla.tofilldatabaseubicapue.Entidades.Escuelas;
import mx.gob.sfa.dss.puebla.tofilldatabaseubicapue.Entidades.Hospitales;
import mx.gob.sfa.dss.puebla.tofilldatabaseubicapue.Entidades.Ministerios_publicos;
import mx.gob.sfa.dss.puebla.tofilldatabaseubicapue.Entidades.Museos;
import mx.gob.sfa.dss.puebla.tofilldatabaseubicapue.Entidades.Notarias;
import mx.gob.sfa.dss.puebla.tofilldatabaseubicapue.Entidades.Panteones;
import mx.gob.sfa.dss.puebla.tofilldatabaseubicapue.Entidades.Pueblos_magicos;
import mx.gob.sfa.dss.puebla.tofilldatabaseubicapue.Entidades.Registro_civil;
import mx.gob.sfa.dss.puebla.tofilldatabaseubicapue.Entidades.Servicios;
import mx.gob.sfa.dss.puebla.tofilldatabaseubicapue.Entidades.Verificentros;
import mx.gob.sfa.dss.puebla.tofilldatabaseubicapue.Interfaces.InterfaceAyuntamientos;
import mx.gob.sfa.dss.puebla.tofilldatabaseubicapue.Interfaces.InterfaceCis;
import mx.gob.sfa.dss.puebla.tofilldatabaseubicapue.Interfaces.InterfaceDep_Ent_Col;
import mx.gob.sfa.dss.puebla.tofilldatabaseubicapue.Interfaces.InterfaceEscuelas;
import mx.gob.sfa.dss.puebla.tofilldatabaseubicapue.Interfaces.InterfaceHospitales;
import mx.gob.sfa.dss.puebla.tofilldatabaseubicapue.Interfaces.InterfaceMinisterios_publicos;
import mx.gob.sfa.dss.puebla.tofilldatabaseubicapue.Interfaces.InterfaceMuseos;
import mx.gob.sfa.dss.puebla.tofilldatabaseubicapue.Interfaces.InterfaceNotarias;
import mx.gob.sfa.dss.puebla.tofilldatabaseubicapue.Interfaces.InterfacePanteones;
import mx.gob.sfa.dss.puebla.tofilldatabaseubicapue.Interfaces.InterfacePueblos_magicos;
import mx.gob.sfa.dss.puebla.tofilldatabaseubicapue.Interfaces.InterfaceRegistro_civil;
import mx.gob.sfa.dss.puebla.tofilldatabaseubicapue.Interfaces.InterfaceServicios;
import mx.gob.sfa.dss.puebla.tofilldatabaseubicapue.Interfaces.InterfaceVerificentros;
import mx.gob.sfa.dss.puebla.tofilldatabaseubicapue.Methods.MethodsDataBase;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by dtit on 14/03/16.
 */
public class ServicioInfo {
    private MethodsDataBase mdb;
    static String url="http://10.0.3.2/UbicaPue/";
    private Ayuntamientos ayuntamientos;
    private Cis cis;
    private Dep_Ent_Col dep_ent_col;
    private Escuelas escuelas;
    private Hospitales hospitales;
    private Ministerios_publicos ministerios_publicos;
    private Museos museos;
    private Notarias notarias;
    private Panteones panteones;
    private Pueblos_magicos pueblos_magicos;
    private Registro_civil registro_civil;
    private Servicios servicios;
    private Verificentros verificentros;

    public void getallayuntamientos(final RealmConfiguration realmConfig )
    {
        Gson gson = new GsonBuilder()
                .setExclusionStrategies(new ExclusionStrategy() {
                    @Override
                    public boolean shouldSkipField(FieldAttributes f) {
                        return f.getDeclaringClass().equals(RealmObject.class);
                    }

                    @Override
                    public boolean shouldSkipClass(Class<?> clazz) {
                        return false;
                    }
                })
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)//
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();


        InterfaceAyuntamientos service =retrofit.create(InterfaceAyuntamientos.class);
        Call<List<Ayuntamientos>> call = service.ayuntamientos();

        call.enqueue(new Callback<List<Ayuntamientos>>() {
            @Override
            public void onResponse(Response<List<Ayuntamientos>> response, Retrofit retrofit) {

                mdb = new MethodsDataBase(realmConfig);
                ayuntamientos = new Ayuntamientos();

                for (int i = 0; i<response.body().size(); i++)
                {
                    try {

                        //Log.e("id_ayuntamiento"," :" + response.body().get(i).getId());

                        ayuntamientos.setId(response.body().get(i).getId());
                        ayuntamientos.setNombre(response.body().get(i).getNombre());
                        ayuntamientos.setAlcalde(response.body().get(i).getAlcalde());
                        ayuntamientos.setDireccion(response.body().get(i).getDireccion());
                        ayuntamientos.setTelefono(response.body().get(i).getTelefono());
                        ayuntamientos.setEmail(response.body().get(i).getEmail());
                        ayuntamientos.setWeb(response.body().get(i).getWeb());
                        ayuntamientos.setLatitud(response.body().get(i).getLatitud());
                        ayuntamientos.setLongitud(response.body().get(i).getLongitud());
                        ayuntamientos.setGeoreferencia(response.body().get(i).getGeoreferencia());
                        ayuntamientos.setId_municipio(response.body().get(i).getId_municipio());
                        ayuntamientos.setMunicipio(response.body().get(i).getMunicipio());
                        mdb.addAyuntamientos(ayuntamientos);




                    }catch (Exception e)
                    {
                        Log.e("error al insertar base de datos:", "Ayuntamientos: " + e.getMessage());

                    }

                }

                //mostrar los datos de la tabla

               /* if(mdb.readAyuntamientosAll() != null)
                {
                    for(Ayuntamientos a2 : mdb.readAyuntamientosAll())
                    {

                        Log.e("REGISTRO: ", "|"+a2.toString()+"|");
                    }
                }*/
            }

            @Override
            public void onFailure(Throwable t) {

                        Log.e("onFailue:ayuntamientos", "f" + t.getMessage());

            }
        });


    }

    public void getallCis(final RealmConfiguration realmConfig)
    {

        Gson gson = new GsonBuilder()
                .setExclusionStrategies(new ExclusionStrategy() {
                    @Override
                    public boolean shouldSkipField(FieldAttributes f) {
                        return f.getDeclaringClass().equals(RealmObject.class);
                    }

                    @Override
                    public boolean shouldSkipClass(Class<?> clazz) {
                        return false;
                    }
                })
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)//
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        InterfaceCis service =retrofit.create(InterfaceCis.class);
        Call<List<Cis>> call = service.Cis();

        call.enqueue(new Callback<List<Cis>>() {
            @Override
            public void onResponse(Response<List<Cis>> response, Retrofit retrofit) {
                mdb = new MethodsDataBase(realmConfig);
                cis = new Cis();

                for(int i = 0; i<response.body().size();i++ )
                {
                    try
                    {
                       Log.e("is_cis", ": " + response.body().get(i).getId()+ "nombre: " +  response.body().get(i).getCis());

                        cis.setId(response.body().get(i).getId());
                        cis.setCis(response.body().get(i).getCis());
                        cis.setDireccion(response.body().get(i).getDireccion());
                        Log.e("este", cis.getCis());
                        cis.setTelefono(response.body().get(i).getTelefono());
                        cis.setLatitud(response.body().get(i).getLatitud());
                        cis.setLongitud(response.body().get(i).getLongitud());
                        cis.setStatus(response.body().get(i).getStatus());
                        cis.setDescripcion(response.body().get(i).getDescripcion());
                        cis.setHorarios(response.body().get(i).getHorarios());
                        mdb.addCis(cis);

                    }catch (Exception e)
                    {
                        Log.e("Error bd cis: ", e.getMessage());
                    }

                }

            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("Error getallAyundtam",":" + t.getMessage());
            }
        });


    }

    public void getallDep_Ent_Col(final  RealmConfiguration realmConfig)
    {
        Gson gson = new GsonBuilder()
                .setExclusionStrategies(new ExclusionStrategy() {
                    @Override
                    public boolean shouldSkipField(FieldAttributes f) {
                        return f.getDeclaringClass().equals(RealmObject.class);
                    }

                    @Override
                    public boolean shouldSkipClass(Class<?> clazz) {
                        return false;
                    }
                })
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)//
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();


        InterfaceDep_Ent_Col service =retrofit.create(InterfaceDep_Ent_Col.class);
        Call<List<Dep_Ent_Col>> call = service.dep_ent_col();

        call.enqueue(new Callback<List<Dep_Ent_Col>>() {
            @Override
            public void onResponse(Response<List<Dep_Ent_Col>> response, Retrofit retrofit) {
                dep_ent_col = new Dep_Ent_Col();
                mdb = new MethodsDataBase(realmConfig);

                for (int i = 0; i<response.body().size(); i++)
                {

                    try
                    {
                        //Log.e("id dep_col", ": " +response.body().get(i).getId());

                        dep_ent_col.setId(response.body().get(i).getId());
                        dep_ent_col.setDep_ent(response.body().get(i).getDep_ent());
                        dep_ent_col.setDireccion(response.body().get(i).getDireccion());
                        dep_ent_col.setTelefono(response.body().get(i).getTelefono());
                        dep_ent_col.setLatitud(response.body().get(i).getLatitud());
                        dep_ent_col.setLongitud(response.body().get(i).getLongitud());
                        dep_ent_col.setTipo(response.body().get(i).getTipo());
                        dep_ent_col.setStatus(response.body().get(i).getStatus());
                        dep_ent_col.setDescripcion(response.body().get(i).getDescripcion());
                        dep_ent_col.setTramites(response.body().get(i).getTramites());
                        dep_ent_col.setHorario(response.body().get(i).getHorario());
                        mdb.addDep_Ent_col(dep_ent_col);

                    }catch (Exception e)
                    {
                        Log.e("Error insert de_encol", e.getMessage());
                    }


                }

            }

            @Override
            public void onFailure(Throwable t) {
                    Log.e("OnFailure: ", t.getMessage());
            }
        });

    }

    public void getallEscuelas(final RealmConfiguration realmConfig)
    {
        Gson gson = new GsonBuilder()
                .setExclusionStrategies(new ExclusionStrategy() {
                    @Override
                    public boolean shouldSkipField(FieldAttributes f) {
                        return f.getDeclaringClass().equals(RealmObject.class);
                    }

                    @Override
                    public boolean shouldSkipClass(Class<?> clazz) {
                        return false;
                    }
                })
                .create();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)//
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        InterfaceEscuelas service = retrofit.create(InterfaceEscuelas.class);
        Call<List<Escuelas>> call = service.Escuelas();


        call.enqueue(new Callback<List<Escuelas>>() {
            @Override
            public void onResponse(Response<List<Escuelas>> response, Retrofit retrofit) {
                escuelas = new Escuelas();
                mdb = new MethodsDataBase(realmConfig);

                for (int i = 0; i < response.body().size(); i++)
                {

                  //  Log.e("id:esc:class:servicio ", String.valueOf(response.body().get(i).getId_escuela()) +" numero " + i);

                    try {
                        //escuelas = new Escuelas();
                        escuelas.setId_escuela(response.body().get(i).getId_escuela());
                        escuelas.setId_municipio(response.body().get(i).getId_municipio());
                        escuelas.setRegion_socioeconomica(response.body().get(i).getRegion_socioeconomica());
                        escuelas.setTipo_escuela(response.body().get(i).getTipo_escuela());
                        escuelas.setEntidad(response.body().get(i).getEntidad());
                        escuelas.setMunicipio(response.body().get(i).getMunicipio());
                        escuelas.setLocalidad(response.body().get(i).getLocalidad());
                        escuelas.setAmbito(response.body().get(i).getAmbito());
                        escuelas.setClave(response.body().get(i).getClave());
                        escuelas.setTurno(response.body().get(i).getTurno());
                        escuelas.setNombre(response.body().get(i).getNombre());
                        escuelas.setServicio(response.body().get(i).getServicio());
                        escuelas.setControl(response.body().get(i).getControl());
                        escuelas.setOpciones(response.body().get(i).getOpciones());
                        escuelas.setDireccion(response.body().get(i).getDireccion());
                        escuelas.setTelefono(response.body().get(i).getTelefono());
                        escuelas.setLatitud(response.body().get(i).getLatitud());
                        escuelas.setLongitud(response.body().get(i).getLongitud());
                        escuelas.setGeoreferencia(response.body().get(i).getGeoreferencia());
                        //mdb = new MethodsDataBase (realmConfig);
                        mdb.addEscuelas(escuelas);
                    } catch (Exception e) {
                        Log.e("Error al inserta bd esc", e.getMessage());

                    }


                }

                // Log.e("onResponse ", response.body().get(0).getNombre());
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("onFailure esc ", t.getMessage());

            }
        });



    }

    public  void  getallHospitales(final RealmConfiguration realmConfig)
    {
        Gson gson = new GsonBuilder()
                .setExclusionStrategies(new ExclusionStrategy() {
                    @Override
                    public boolean shouldSkipField(FieldAttributes f) {
                        return f.getDeclaringClass().equals(RealmObject.class);
                    }

                    @Override
                    public boolean shouldSkipClass(Class<?> clazz) {
                        return false;
                    }
                })
                .create();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)//
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        InterfaceHospitales service = retrofit.create(InterfaceHospitales.class);
        Call<List<Hospitales>> call = service.hospitales();

        call.enqueue(new Callback<List<Hospitales>>() {
            @Override
            public void onResponse(Response<List<Hospitales>> response, Retrofit retrofit) {
                hospitales = new Hospitales();
                mdb = new MethodsDataBase(realmConfig);

                for (int i = 0; i<response.body().size(); i++)
                {
                    try
                    {
                      //  Log.e("id hospital", " " + response.body().get(i).getId_hospital());
                        hospitales.setId_hospital(response.body().get(i).getId_hospital());
                        hospitales.setTipo(response.body().get(i).getTipo());
                        hospitales.setId_municipio(response.body().get(i).getId_municipio());
                        hospitales.setMunicipio(response.body().get(i).getMunicipio());
                        hospitales.setNombre(response.body().get(i).getNombre());
                        hospitales.setTelefono(response.body().get(i).getTelefono());
                        hospitales.setDireccion(response.body().get(i).getDireccion());
                        hospitales.setCamas(response.body().get(i).getCamas());
                        hospitales.setConsultorios(response.body().get(i).getConsultorios());
                        hospitales.setFarmacias(response.body().get(i).getFarmacias());
                        hospitales.setLaboratorios(response.body().get(i).getLaboratorios());
                        hospitales.setCentros_salud_atendidos(response.body().get(i).getCentros_salud_atendidos());
                        hospitales.setDetalles(response.body().get(i).getDetalles());
                        hospitales.setGeoreferencia(response.body().get(i).getGeoreferencia());
                        hospitales.setLongitud(response.body().get(i).getLongitud());
                        hospitales.setLatitud(response.body().get(i).getLatitud());
                        hospitales.setServicios_que_proporciona(response.body().get(i).getServicios_que_proporciona());
                        mdb.addHospitales(hospitales);

                    }catch (Exception e)
                    {
                        Log.e("error al insert bdatos:", "Hospitales: " + e.getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("onFailue:Hospitales", "f" + t.getMessage());
            }
        });
    }

    public void getallMinisteriosPublicos(final RealmConfiguration realmConfig)
    {
        Gson gson = new GsonBuilder()
                .setExclusionStrategies(new ExclusionStrategy() {
                    @Override
                    public boolean shouldSkipField(FieldAttributes f) {
                        return f.getDeclaringClass().equals(RealmObject.class);
                    }

                    @Override
                    public boolean shouldSkipClass(Class<?> clazz) {
                        return false;
                    }
                })
                .create();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)//
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        InterfaceMinisterios_publicos service = retrofit.create(InterfaceMinisterios_publicos.class);
        Call<List<Ministerios_publicos>> call = service.ministerios_publicos();

        call.enqueue(new Callback<List<Ministerios_publicos>>() {
            @Override
            public void onResponse(Response<List<Ministerios_publicos>> response, Retrofit retrofit) {

                ministerios_publicos = new Ministerios_publicos();
                mdb = new MethodsDataBase(realmConfig);

                for(int i = 0; i< response.body().size(); i++ )
                {
                    try
                    {
                      //  Log.e("id minist", ": " +response.body().get(i).getId());
                        ministerios_publicos.setId(response.body().get(i).getId());
                        ministerios_publicos.setTipo(response.body().get(i).getTipo());
                        ministerios_publicos.setId_municipio(response.body().get(i).getId_municipio());
                        ministerios_publicos.setMunicipio(response.body().get(i).getMunicipio());
                        ministerios_publicos.setDelegacion(response.body().get(i).getDelegacion());
                        ministerios_publicos.setDireccion(response.body().get(i).getDireccion());
                        ministerios_publicos.setHorario(response.body().get(i).getHorario());
                        ministerios_publicos.setTelefono(response.body().get(i).getTelefono());
                        ministerios_publicos.setLatitud(response.body().get(i).getLatitud());
                        ministerios_publicos.setLongitud(response.body().get(i).getLongitud());
                        mdb.addMinisterios_publicos(ministerios_publicos);

                    }catch (Exception e)
                    {
                        Log.e("Error insert bd minis_public", ":" + e.getMessage());
                    }
                }

            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("Error getallMinisteripubli",":" + t.getMessage());
            }
        });

    }


    public void getallMuseos(final RealmConfiguration realmConfig)
    {
        Gson gson = new GsonBuilder()
                .setExclusionStrategies(new ExclusionStrategy() {
                    @Override
                    public boolean shouldSkipField(FieldAttributes f) {
                        return f.getDeclaringClass().equals(RealmObject.class);
                    }

                    @Override
                    public boolean shouldSkipClass(Class<?> clazz) {
                        return false;
                    }
                })
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)//
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        final InterfaceMuseos service =retrofit.create(InterfaceMuseos.class);
        Call<List<Museos>> call = service.museos();

        call.enqueue(new Callback<List<Museos>>() {
            @Override
            public void onResponse(Response<List<Museos>> response, Retrofit retrofit) {
                museos = new Museos();
                mdb = new MethodsDataBase(realmConfig);

                for(int i = 0; i < response.body().size(); i++)
                {
                    try
                    {
                        //Log.e("id museos", ": " +response.body().get(i).getId());
                        museos.setId(response.body().get(i).getId());
                        museos.setId_municipio(response.body().get(i).getId_municipio());
                        museos.setMunicipio(response.body().get(i).getMunicipio());
                        museos.setNombre(response.body().get(i).getNombre());
                        museos.setDireccion(response.body().get(i).getDireccion());
                        museos.setTelefono(response.body().get(i).getTelefono());
                        museos.setHorario(response.body().get(i).getHorario());
                        museos.setGeoreferencia(response.body().get(i).getGeoreferencia());
                        museos.setLatitud(response.body().get(i).getLatitud());
                        museos.setLongitud(response.body().get(i).getLongitud());
                        museos.setCostos(response.body().get(i).getCostos());
                        mdb.addMuseos(museos);

                    }catch (Exception e)
                    {
                        Log.e("error insetbdMuseos", ":" + e.getMessage());
                    }

                }

            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("error Museos", ":" + t.getMessage());
            }
        });
    }

    public void getallNotarias(final RealmConfiguration realmConfig)
    {

        Gson gson = new GsonBuilder()
                .setExclusionStrategies(new ExclusionStrategy() {
                    @Override
                    public boolean shouldSkipField(FieldAttributes f) {
                        return f.getDeclaringClass().equals(RealmObject.class);
                    }

                    @Override
                    public boolean shouldSkipClass(Class<?> clazz) {
                        return false;
                    }
                })
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)//
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();


        InterfaceNotarias service =retrofit.create(InterfaceNotarias.class);
        Call<List<Notarias>> call = service.notarias();

        call.enqueue(new Callback<List<Notarias>>() {
            @Override
            public void onResponse(Response<List<Notarias>> response, Retrofit retrofit) {
                notarias = new Notarias();
                mdb = new MethodsDataBase(realmConfig);

                for(int i=0; i<response.body().size(); i++)
                {
                    try
                    {
                        //Log.e("id notarias", ": " +response.body().get(i).getId());
                        notarias.setId(response.body().get(i).getId());
                        notarias.setNum_notaria(response.body().get(i).getNum_notaria());
                        notarias.setTitular(response.body().get(i).getTitular());
                        notarias.setAuxiliar(response.body().get(i).getAuxiliar());
                        notarias.setDireccion(response.body().get(i).getDireccion());
                        notarias.setCp(response.body().get(i).getCp());
                        notarias.setTelefono_fax(response.body().get(i).getTelefono_fax());
                        notarias.setEmail(response.body().get(i).getEmail());
                        notarias.setHorario(response.body().get(i).getHorario());
                        notarias.setDistrito(response.body().get(i).getDistrito());
                        notarias.setId_municipio(response.body().get(i).getId_municipio());
                        notarias.setMunicipio(response.body().get(i).getMunicipio());
                        notarias.setGeoreferencia(response.body().get(i).getGeoreferencia());
                        notarias.setLatitud(response.body().get(i).getLatitud());
                        notarias.setLongitud(response.body().get(i).getLongitud());
                        mdb.addNotarias(notarias);

                    }catch (Exception e)
                    {
                        Log.e("error insert bdnotarias", "f" + e.getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("onFailue:notarias", "f" + t.getMessage());
            }
        });
    }

    public  void  getallPanteones(final RealmConfiguration realmConfig)
    {
        Gson gson = new GsonBuilder()
                .setExclusionStrategies(new ExclusionStrategy() {
                    @Override
                    public boolean shouldSkipField(FieldAttributes f) {
                        return f.getDeclaringClass().equals(RealmObject.class);
                    }

                    @Override
                    public boolean shouldSkipClass(Class<?> clazz) {
                        return false;
                    }
                })
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)//
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();


        InterfacePanteones service =retrofit.create(InterfacePanteones.class);
        Call<List<Panteones>> call = service.panteones();

        call.enqueue(new Callback<List<Panteones>>() {
            @Override
            public void onResponse(Response<List<Panteones>> response, Retrofit retrofit) {
                panteones = new Panteones();
                mdb = new MethodsDataBase(realmConfig);

                for (int i = 0; i< response.body().size(); i++)
                {
                    try
                    {
                        //Log.e("id dep_col", ": " +response.body().get(i).getId());
                        panteones.setId(response.body().get(i).getId());
                        panteones.setNombre(response.body().get(i).getNombre());
                        panteones.setDescripcion(response.body().get(i).getDescripcion());
                        panteones.setDireccion(response.body().get(i).getDireccion());
                        panteones.setTelefono(response.body().get(i).getTelefono());
                        panteones.setHorario(response.body().get(i).getHorario());
                        panteones.setLatitud(response.body().get(i).getLatitud());
                        panteones.setLongitud(response.body().get(i).getLongitud());
                        panteones.setGeoreferencia(response.body().get(i).getGeoreferencia());
                        panteones.setId_municipio(response.body().get(i).getId_municipio());
                        panteones.setMunicipio(response.body().get(i).getMunicipio());
                        mdb.addPanteones(panteones);

                    }catch (Exception e)
                    {
                        Log.e("Error Insertpanteones",":" + e.getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("Error getallPanteone",":" + t.getMessage());
            }
        });
    }

    public  void getallPueblosMagicos(final RealmConfiguration realmConfig)
    {
        Gson gson = new GsonBuilder()
                .setExclusionStrategies(new ExclusionStrategy() {
                    @Override
                    public boolean shouldSkipField(FieldAttributes f) {
                        return f.getDeclaringClass().equals(RealmObject.class);
                    }

                    @Override
                    public boolean shouldSkipClass(Class<?> clazz) {
                        return false;
                    }
                })
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)//
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();


        InterfacePueblos_magicos service =retrofit.create(InterfacePueblos_magicos.class);
        Call<List<Pueblos_magicos>> call = service.pueblosmagicos();

        call.enqueue(new Callback<List<Pueblos_magicos>>() {
            @Override
            public void onResponse(Response<List<Pueblos_magicos>> response, Retrofit retrofit) {
                pueblos_magicos = new Pueblos_magicos();
                mdb = new MethodsDataBase(realmConfig);

                for(int i =0; i < response.body().size(); i++)
                {
                    try
                    {
                        //Log.e("id pm", ": " +response.body().get(i).getId());
                        pueblos_magicos.setId(response.body().get(i).getId());
                        pueblos_magicos.setNombre(response.body().get(i).getNombre());
                        pueblos_magicos.setDescripcion_corta(response.body().get(i).getDescripcion_corta());
                        pueblos_magicos.setDescripcion(response.body().get(i).getDescripcion());
                        pueblos_magicos.setSierra(response.body().get(i).getSierra());
                        pueblos_magicos.setClima(response.body().get(i).getClima());
                        pueblos_magicos.setColindancias(response.body().get(i).getColindancias());
                        pueblos_magicos.setUrl(response.body().get(i).getUrl());
                        pueblos_magicos.setLatitud(response.body().get(i).getLatitud());
                        pueblos_magicos.setLongitud(response.body().get(i).getLongitud());
                        pueblos_magicos.setId_municipio(response.body().get(i).getId_municipio());
                        pueblos_magicos.setMunicipio(response.body().get(i).getMunicipio());
                        mdb.addPueblos_magicos(pueblos_magicos);


                    }catch (Exception e)
                    {
                        Log.e("insert pueblos: ", e.getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("OnFailure pueblos: ", t.getMessage());
            }
        });

    }


    public void getallregistrocivil(final  RealmConfiguration realmConfig)
    {
        Gson gson = new GsonBuilder()
                .setExclusionStrategies(new ExclusionStrategy() {
                    @Override
                    public boolean shouldSkipField(FieldAttributes f) {
                        return f.getDeclaringClass().equals(RealmObject.class);
                    }

                    @Override
                    public boolean shouldSkipClass(Class<?> clazz) {
                        return false;
                    }
                })
                .create();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)//
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();


        InterfaceRegistro_civil service = retrofit.create(InterfaceRegistro_civil.class);
        Call<List<Registro_civil>> call = service.registrocivil();

        call.enqueue(new Callback<List<Registro_civil>>() {
            @Override
            public void onResponse(Response<List<Registro_civil>> response, Retrofit retrofit) {
                mdb = new MethodsDataBase (realmConfig);
                registro_civil = new Registro_civil();

                for (int i = 0; i < response.body().size(); i++)
                {
                    try
                    {

                        Log.e("id rc", ": " +response.body().get(i).getId()+ "latitud: " + response.body().get(i).getLatitud());
                        registro_civil.setId(response.body().get(i).getId());
                        registro_civil.setNombre(response.body().get(i).getNombre());
                        registro_civil.setDescripcion(response.body().get(i).getDescripcion());
                        registro_civil.setDireccion(response.body().get(i).getDireccion());
                        registro_civil.setTelefono(response.body().get(i).getTelefono());
                        registro_civil.setLatitud(response.body().get(i).getLatitud());
                        Log.e("Latitud"," es: " + registro_civil.getLatitud());
                        registro_civil.setLongitud(response.body().get(i).getLongitud());
                        registro_civil.setId_municipio(response.body().get(i).getId_municipio());
                        registro_civil.setMunicipio(response.body().get(i).getMunicipio());
                        mdb.addRegistro_civil(registro_civil);

                    }catch (Exception e)
                    {
                        Log.e("error al insert bd rec:", e.getMessage());

                    }

                }

            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("onFailure registro: ",t.getMessage());

            }
        });


    }


    public void getallservicios(final RealmConfiguration realmConfig)
    {
        Gson gson = new GsonBuilder()
                .setExclusionStrategies(new ExclusionStrategy() {
                    @Override
                    public boolean shouldSkipField(FieldAttributes f) {
                        return f.getDeclaringClass().equals(RealmObject.class);
                    }

                    @Override
                    public boolean shouldSkipClass(Class<?> clazz) {
                        return false;
                    }
                })
                .create();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)//
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();


       InterfaceServicios service = retrofit.create(InterfaceServicios.class);
        Call<List<Servicios>> call = service.servicios();

        call.enqueue(new Callback<List<Servicios>>() {
            @Override
            public void onResponse(Response<List<Servicios>> response, Retrofit retrofit) {
                servicios = new Servicios();
                mdb = new MethodsDataBase(realmConfig);

                for(int i = 0; i< response.body().size(); i++)
                {
                    try
                    {
                        //Log.e("id ser", ": " +response.body().get(i).getId());
                        servicios.setId(response.body().get(i).getId());
                        servicios.setNombre(response.body().get(i).getNombre());
                        servicios.setTipo(response.body().get(i).getTipo());
                        servicios.setTelefono(response.body().get(i).getTelefono());
                        servicios.setDescripcion(response.body().get(i).getDescripcion());
                        servicios.setDireccion(response.body().get(i).getDireccion());
                        servicios.setHorario(response.body().get(i).getHorario());
                        servicios.setLatitud(response.body().get(i).getLatitud());
                        servicios.setLongitud(response.body().get(i).getLongitud());
                        servicios.setId_municipio(response.body().get(i).getId_municipio());
                        servicios.setMunicipio(response.body().get(i).getMunicipio());
                        mdb.addServicios(servicios);

                    }catch (Exception e)
                    {
                        Log.e("InsertarBd servicios", "f" + e.getMessage());
                    }
                }

            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("onFailue:Servicios", "f" + t.getMessage());
            }
        });




    }


    public void getalveerificentros(final  RealmConfiguration realmConfig)
    {
        Gson gson = new GsonBuilder()
                .setExclusionStrategies(new ExclusionStrategy() {
                    @Override
                    public boolean shouldSkipField(FieldAttributes f) {
                        return f.getDeclaringClass().equals(RealmObject.class);
                    }

                    @Override
                    public boolean shouldSkipClass(Class<?> clazz) {
                        return false;
                    }
                })
                .create();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)//
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();


        InterfaceVerificentros service = retrofit.create(InterfaceVerificentros.class);
        Call<List<Verificentros>> call = service.verificentros();

        call.enqueue(new Callback<List<Verificentros>>() {
            @Override
            public void onResponse(Response<List<Verificentros>> response, Retrofit retrofit) {

                verificentros = new Verificentros();
                mdb = new MethodsDataBase(realmConfig);

                for(int i =0; i<response.body().size(); i++)
                {
                    try
                    {
                        Log.e("id veri", ": " +response.body().get(i).getId() + " latitud" + response.body().get(i).getLatitud());
                        verificentros.setId(response.body().get(i).getId());
                        verificentros.setNombre(response.body().get(i).getNombre());
                        verificentros.setTipo(response.body().get(i).getTipo());
                        verificentros.setDescripcion(response.body().get(i).getDescripcion());
                        verificentros.setDireccion(response.body().get(i).getDireccion());
                        verificentros.setTelefono(response.body().get(i).getTelefono());
                        verificentros.setHorario(response.body().get(i).getHorario());
                        verificentros.setLatitud(response.body().get(i).getLatitud());
                        Log.e("la", "es:" + verificentros.getLatitud());
                        verificentros.setLongitud(response.body().get(i).getLongitud());
                        verificentros.setId_municipio(response.body().get(i).getId_municipio());
                        verificentros.setMunicipio(response.body().get(i).getMunicipio());
                        mdb.addVerificentros(verificentros);

                    }catch (Exception e)
                    {
                        Log.e("Inser verificentros", "f" + e.getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("onFailure servicios", "f" + t.getMessage());
            }
        });


    }

}
