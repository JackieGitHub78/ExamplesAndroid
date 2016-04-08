package mx.gob.sfa.dss.puebla.tofilldatabaseubicapue.Methods;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
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
import mx.gob.sfa.dss.puebla.tofilldatabaseubicapue.Interfaces.InterfaceMetoDataBase;

/**
 * Created by dtit on 14/03/16.
 */
public class MethodsDataBase implements InterfaceMetoDataBase{
    private Realm realm;


    /*
    * variables de tipo entidad*/
    private Ayuntamientos ayuntamientos1;
    private Cis cis1;
    private Dep_Ent_Col dep_ent_col1;
    private Escuelas escuelas1;
    private Hospitales hospitales1;
    private Ministerios_publicos ministerios_publicos1;
    private Museos museos1;
    private Notarias notarias1;
    private Panteones panteones1;
    private Pueblos_magicos pueblos_magicos1;
    private Registro_civil registro_civil1;
    private Servicios servicios1;
    private Verificentros verificentros1;
    private RealmConfiguration realmConfig;

   /* public MethodsDataBase(Context c)
    {
       realmConfiguration = new RealmConfiguration.Builder(c).build();
        realm = Realm.getInstance(realmConfiguration);
        //realm = realm2;
    }*/

    /*public MethodsDataBase(RealmConfiguration realConfig) {
        realm = Realm.getInstance(realConfig);
    }

    public MethodsDataBase() {
    }*/

    public MethodsDataBase(RealmConfiguration realmCo) {
        realmConfig = realmCo;
        realm = Realm.getInstance(realmConfig);
    }

    @Override
    public void addAyuntamientos(Ayuntamientos ayuntaminetos) {
        realm.beginTransaction();
        ayuntamientos1 = realm.createObject(Ayuntamientos.class);
        ayuntamientos1.setId(ayuntaminetos.getId());
        ayuntamientos1.setNombre(ayuntaminetos.getNombre());
        ayuntamientos1.setAlcalde(ayuntaminetos.getAlcalde());
        ayuntamientos1.setDireccion(ayuntaminetos.getDireccion());
        ayuntamientos1.setTelefono(ayuntaminetos.getTelefono());
        ayuntamientos1.setEmail(ayuntaminetos.getEmail());
        ayuntamientos1.setWeb(ayuntaminetos.getWeb());
        ayuntamientos1.setLatitud(ayuntaminetos.getLatitud());
        ayuntamientos1.setLongitud(ayuntaminetos.getLongitud());
        ayuntamientos1.setGeoreferencia(ayuntaminetos.getGeoreferencia());
        ayuntamientos1.setId_municipio(ayuntaminetos.getId_municipio());
        ayuntamientos1.setMunicipio(ayuntaminetos.getMunicipio());
        realm.commitTransaction();

    }

    @Override
    public void addCis(Cis cis) {

        realm.beginTransaction();
        cis1 = realm.createObject(Cis.class);
        cis1.setId(cis.getId());
        cis1.setCis(cis.getCis());
        cis1.setDireccion(cis.getDireccion());
        cis1.setTelefono(cis.getTelefono());
        cis1.setLatitud(cis.getLatitud());
        cis1.setLongitud(cis.getLongitud());
        cis1.setStatus(cis.getStatus());
        cis1.setDescripcion(cis.getDescripcion());
        cis1.setHorarios(cis.getHorarios());
        realm.commitTransaction();

    }

    @Override
    public void addDep_Ent_col(Dep_Ent_Col dep_ent_col) {

        realm.beginTransaction();
        dep_ent_col1 = realm.createObject(Dep_Ent_Col.class);
        dep_ent_col1.setId(dep_ent_col.getId());
        dep_ent_col1.setDep_ent(dep_ent_col.getDep_ent());
        dep_ent_col1.setDireccion(dep_ent_col.getDireccion());
        dep_ent_col1.setTelefono(dep_ent_col.getTelefono());
        dep_ent_col1.setLatitud(dep_ent_col.getLatitud());
        dep_ent_col1.setLongitud(dep_ent_col.getLongitud());
        dep_ent_col1.setTipo(dep_ent_col.getTipo());
        dep_ent_col1.setStatus(dep_ent_col.getStatus());
        dep_ent_col1.setDescripcion(dep_ent_col.getDescripcion());
        dep_ent_col1.setTramites(dep_ent_col.getTramites());
        dep_ent_col1.setHorario(dep_ent_col.getHorario());
        realm.commitTransaction();


    }

    @Override
    public void addEscuelas(Escuelas escuelas) {

        realm.beginTransaction();
        escuelas1 = realm.createObject(Escuelas.class);

        escuelas1.setId_escuela(escuelas.getId_escuela());
        escuelas1.setId_municipio(escuelas.getId_municipio());
        escuelas1.setRegion_socioeconomica(escuelas.getRegion_socioeconomica());
        escuelas1.setTipo_escuela(escuelas.getTipo_escuela());
        escuelas1.setEntidad(escuelas.getEntidad());
        escuelas1.setMunicipio(escuelas.getMunicipio());
        escuelas1.setLocalidad(escuelas.getLocalidad());
        escuelas1.setAmbito(escuelas.getAmbito());
        escuelas1.setClave(escuelas.getClave());
        escuelas1.setTurno(escuelas.getTurno());
        escuelas1.setNombre(escuelas.getNombre());
        escuelas1.setServicio(escuelas.getServicio());
        escuelas1.setControl(escuelas.getControl());
        escuelas1.setOpciones(escuelas.getOpciones());
        escuelas1.setDireccion(escuelas.getDireccion());
        escuelas1.setTelefono(escuelas.getTelefono());
        escuelas1.setLatitud(escuelas.getLatitud());
        escuelas1.setLongitud(escuelas.getLongitud());
        escuelas1.setGeoreferencia(escuelas.getGeoreferencia());

        realm.commitTransaction();

    }

    @Override
    public void addHospitales(Hospitales hospitales) {
        realm.beginTransaction();
        hospitales1 = realm.createObject(Hospitales.class);
        hospitales1.setId_hospital(hospitales.getId_hospital());
        hospitales1.setTipo(hospitales.getTipo());
        hospitales1.setId_municipio(hospitales.getId_municipio());
        hospitales1.setMunicipio(hospitales.getMunicipio());
        hospitales1.setNombre(hospitales.getNombre());
        hospitales1.setTelefono(hospitales.getTelefono());
        hospitales1.setDireccion(hospitales.getDireccion());
        hospitales1.setCamas(hospitales.getCamas());
        hospitales1.setConsultorios(hospitales.getConsultorios());
        hospitales1.setFarmacias(hospitales.getFarmacias());
        hospitales1.setLaboratorios(hospitales.getLaboratorios());
        hospitales1.setCentros_salud_atendidos(hospitales.getCentros_salud_atendidos());
        hospitales1.setDetalles(hospitales.getDetalles());
        hospitales1.setGeoreferencia(hospitales.getGeoreferencia());
        hospitales1.setLatitud(hospitales.getLatitud());
        hospitales1.setLongitud(hospitales.getLongitud());
        hospitales1.setServicios_que_proporciona(hospitales.getServicios_que_proporciona());
        realm.commitTransaction();


    }

    @Override
    public void addMinisterios_publicos(Ministerios_publicos ministerios_publicos) {

        realm.beginTransaction();
        ministerios_publicos1 = realm.createObject(Ministerios_publicos.class);
        ministerios_publicos1.setId(ministerios_publicos.getId());
        ministerios_publicos1.setTipo(ministerios_publicos.getTipo());
        ministerios_publicos1.setId_municipio(ministerios_publicos.getId_municipio());
        ministerios_publicos1.setMunicipio(ministerios_publicos.getMunicipio());
        ministerios_publicos1.setDelegacion(ministerios_publicos.getDelegacion());
        ministerios_publicos1.setDireccion(ministerios_publicos.getDireccion());
        ministerios_publicos1.setDelegacion(ministerios_publicos.getDelegacion());
        ministerios_publicos1.setHorario(ministerios_publicos.getHorario());
        ministerios_publicos1.setHorario(ministerios_publicos.getHorario());
        ministerios_publicos1.setTelefono(ministerios_publicos.getTelefono());
        ministerios_publicos1.setLatitud(ministerios_publicos.getLatitud());
        ministerios_publicos1.setLongitud(ministerios_publicos.getLongitud());
        realm.commitTransaction();

    }

    @Override
    public void addMuseos(Museos museos) {

        realm.beginTransaction();
        museos1 = realm.createObject(Museos.class);
        museos1.setId(museos.getId());
        museos1.setId_municipio(museos.getId_municipio());
        museos1.setNombre(museos.getNombre());
        museos1.setMunicipio(museos.getMunicipio());
        museos1.setDireccion(museos.getDireccion());
        museos1.setTelefono(museos.getTelefono());
        museos1.setHorario(museos.getHorario());
        museos1.setGeoreferencia(museos.getGeoreferencia());
        museos1.setLatitud(museos.getLatitud());
        museos1.setLongitud(museos.getLongitud());
        museos1.setCostos(museos.getCostos());
        realm.commitTransaction();



    }

    @Override
    public void addNotarias(Notarias notarias) {

        realm.beginTransaction();
        notarias1 = realm.createObject(Notarias.class);
        notarias1.setId(notarias.getId());
        notarias1.setNum_notaria(notarias.getNum_notaria());
        notarias1.setTitular(notarias.getTitular());
        notarias1.setAuxiliar(notarias.getAuxiliar());
        notarias1.setDireccion(notarias.getDireccion());
        notarias1.setCp(notarias.getCp());
        notarias1.setTelefono_fax(notarias.getTelefono_fax());
        notarias1.setEmail(notarias.getEmail());
        notarias1.setHorario(notarias.getHorario());
        notarias1.setDistrito(notarias.getDistrito());
        notarias1.setId_municipio(notarias.getId_municipio());
        notarias1.setMunicipio(notarias.getMunicipio());
        notarias1.setGeoreferencia(notarias.getGeoreferencia());
        notarias1.setLatitud(notarias.getLatitud());
        notarias1.setLongitud(notarias.getLongitud());
        realm.commitTransaction();


    }

    @Override
    public void addPanteones(Panteones panteones) {
        realm.beginTransaction();
        panteones1 = realm.createObject(Panteones.class);
        panteones1.setId(panteones.getId());
        panteones1.setNombre(panteones.getNombre());
        panteones1.setDescripcion(panteones.getDescripcion());
        panteones1.setDireccion(panteones.getDireccion());
        panteones1.setTelefono(panteones.getTelefono());
        panteones1.setHorario(panteones.getHorario());
        panteones1.setLatitud(panteones.getLatitud());
        panteones1.setLongitud(panteones.getLongitud());
        panteones1.setGeoreferencia(panteones.getGeoreferencia());
        panteones1.setId_municipio(panteones.getId_municipio());
        panteones1.setMunicipio(panteones.getMunicipio());
        realm.commitTransaction();

    }

    @Override
    public void addPueblos_magicos(Pueblos_magicos pueblos_magicos) {

        realm.beginTransaction();
        pueblos_magicos1 = realm.createObject(Pueblos_magicos.class);
        pueblos_magicos1.setId(pueblos_magicos.getId());
        pueblos_magicos1.setNombre(pueblos_magicos.getNombre());
        pueblos_magicos1.setDescripcion_corta(pueblos_magicos.getDescripcion_corta());
        pueblos_magicos1.setDescripcion(pueblos_magicos.getDescripcion());
        pueblos_magicos1.setSierra(pueblos_magicos.getSierra());
        pueblos_magicos1.setClima(pueblos_magicos.getClima());
        pueblos_magicos1.setColindancias(pueblos_magicos.getColindancias());
        pueblos_magicos1.setUrl(pueblos_magicos.getUrl());
        pueblos_magicos1.setLongitud(pueblos_magicos.getLongitud());
        pueblos_magicos1.setLatitud(pueblos_magicos.getLatitud());
        pueblos_magicos1.setId_municipio(pueblos_magicos.getId_municipio());
        pueblos_magicos1.setMunicipio(pueblos_magicos.getMunicipio());
        realm.commitTransaction();


    }

    @Override
    public void addRegistro_civil(Registro_civil registro_civil) {

        realm.beginTransaction();
        registro_civil1 = realm.createObject(Registro_civil.class);

        registro_civil1.setId(registro_civil.getId());
        registro_civil1.setNombre(registro_civil.getNombre());
        registro_civil1.setDescripcion(registro_civil.getDescripcion());
        registro_civil1.setDireccion(registro_civil.getDireccion());
        registro_civil1.setTelefono(registro_civil.getTelefono());
        registro_civil1.setLatitud(registro_civil.getLatitud());
        registro_civil1.setLongitud(registro_civil.getLongitud());
        registro_civil1.setId_municipio(registro_civil.getId_municipio());
        registro_civil1.setMunicipio(registro_civil.getMunicipio());

        realm.commitTransaction();


    }

    @Override
    public void addServicios(Servicios servicios) {

        realm.beginTransaction();
        servicios1 =  realm.createObject(Servicios.class);
        servicios1.setId(servicios.getId());
        servicios1.setNombre(servicios.getNombre());
        servicios1.setTipo(servicios.getTipo());
        servicios1.setDescripcion(servicios.getDescripcion());
        servicios1.setDireccion(servicios.getDireccion());
        servicios1.setTelefono(servicios.getTelefono());
        servicios1.setHorario(servicios.getHorario());
        servicios1.setLatitud(servicios.getLatitud());
        servicios1.setLongitud(servicios.getLongitud());
        servicios1.setId_municipio(servicios.getId_municipio());
        servicios1.setMunicipio(servicios.getMunicipio());
        realm.commitTransaction();


    }

    @Override
    public void addVerificentros(Verificentros verificentros) {

        realm.beginTransaction();
        verificentros1 = realm.createObject(Verificentros.class);
        verificentros1.setId(verificentros.getId());
        verificentros1.setNombre(verificentros.getNombre());
        verificentros1.setTipo(verificentros.getTipo());
        verificentros1.setDescripcion(verificentros.getDescripcion());
        verificentros1.setDireccion(verificentros.getDireccion());
        verificentros1.setTelefono(verificentros.getTelefono());
        verificentros1.setHorario(verificentros.getHorario());
        verificentros1.setLatitud(verificentros.getLatitud());
        verificentros1.setLongitud(verificentros.getLongitud());
        verificentros1.setId_municipio(verificentros.getId_municipio());
        verificentros1.setMunicipio(verificentros.getMunicipio());
        realm.commitTransaction();


    }

    @Override
    public RealmResults<Ayuntamientos> readAyuntamientosAll() {
        RealmResults<Ayuntamientos> result = realm.where(Ayuntamientos.class).findAll();
        return result;
    }

    @Override
    public RealmResults<Cis> readCisAll() {
        RealmResults<Cis> result = realm.where(Cis.class).findAll();
        return result;
    }

    @Override
    public RealmResults<Dep_Ent_Col> readDep_Ent_ColAll() {
        RealmResults<Dep_Ent_Col> result = realm.where(Dep_Ent_Col.class).findAll();
        return result;
    }

    @Override
    public RealmResults<Escuelas> readEscuelasAll() {
        RealmResults<Escuelas> result = realm.where(Escuelas.class).findAll();
        return null;
    }

    @Override
    public RealmResults<Hospitales> readHopitalesAll() {
        RealmResults<Hospitales> result = realm.where(Hospitales.class).findAll();
        return result;
    }

    @Override
    public RealmResults<Ministerios_publicos> readMinisterios_publicosAll() {
        RealmResults<Ministerios_publicos> result = realm.where(Ministerios_publicos.class).findAll();
        return result;
    }

    @Override
    public RealmResults<Museos> readMuseosAll() {
        RealmResults<Museos> result = realm.where(Museos.class).findAll();
        return result;
    }

    @Override
    public RealmResults<Notarias> readNotariasAll() {
        RealmResults<Notarias> result = realm.where(Notarias.class).findAll();
        return result;
    }

    @Override
    public RealmResults<Panteones> readPanteaonesAll() {
        RealmResults<Panteones> result = realm.where(Panteones.class).findAll();
        return result;
    }

    @Override
    public RealmResults<Pueblos_magicos> readPueblos_magicosAll() {
        RealmResults<Pueblos_magicos> result = realm.where(Pueblos_magicos.class).findAll();
        return result;
    }

    @Override
    public RealmResults<Registro_civil> readRegistro_civilAll() {
        RealmResults<Registro_civil> result = realm.where(Registro_civil.class).findAll();
        return result;
    }

    @Override
    public RealmResults<Servicios> readServiciosAll() {
        RealmResults<Servicios> result = realm.where(Servicios.class).findAll();
        return result;
    }

    @Override
    public RealmResults<Verificentros> readVerificentrosAll() {
        RealmResults<Verificentros> results = realm.where(Verificentros.class).findAll();
        return results;
    }

    @Override
    public RealmResults<Escuelas> readEscuelasTipo(int tipo) {

        RealmResults<Escuelas> esc  = realm.where(Escuelas.class).equalTo("tipo_escuela",tipo).findAll();
        return esc;
    }


}
