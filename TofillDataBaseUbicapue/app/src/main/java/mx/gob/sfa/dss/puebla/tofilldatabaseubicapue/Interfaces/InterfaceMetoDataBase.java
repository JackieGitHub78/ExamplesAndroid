package mx.gob.sfa.dss.puebla.tofilldatabaseubicapue.Interfaces;

import java.util.List;

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

/**
 * Created by dtit on 11/03/16.
 */
public interface InterfaceMetoDataBase {
    //:::::::::::::::::metodos para agregar a la bd

    public void addAyuntamientos(Ayuntamientos ayuntaminetos);
    public void addCis(Cis cis);
    public void addDep_Ent_col(Dep_Ent_Col dep_ent_col);
    public void addEscuelas(Escuelas escuelas);
    public void addHospitales(Hospitales hospitales);
    public void addMinisterios_publicos (Ministerios_publicos ministerios_publicos);
    public void addMuseos(Museos museos);
    public void addNotarias(Notarias notarias);
    public void addPanteones (Panteones panteones);
    public void addPueblos_magicos(Pueblos_magicos pueblos_magicos);
    public void addRegistro_civil(Registro_civil registro_civil);
    public void addServicios(Servicios servicios);
    public void addVerificentros(Verificentros verificentros);

    //::::::::::::::::: fin metodos para agregar a la bd

    //::::::::::::::::: mètodos para leer todos los campos de la tablas
    public List<Ayuntamientos> readAyuntamientosAll();
    public List<Cis> readCisAll();
    public List<Dep_Ent_Col> readDep_Ent_ColAll();
    public List<Escuelas> readEscuelasAll();
    public List<Hospitales> readHopitalesAll();
    public List<Ministerios_publicos> readMinisterios_publicosAll();
    public List<Museos> readMuseosAll();
    public List<Notarias> readNotariasAll();
    public List<Panteones> readPanteaonesAll();
    public List<Pueblos_magicos> readPueblos_magicosAll();
    public List<Registro_civil> readRegistro_civilAll();
    public List<Servicios> readServiciosAll();
    public List<Verificentros> readVerificentrosAll();


    //::::::::::::::::: fin mètodos  para leer todos los campos de la tablas

    //consulta de las escuelas por tipo
    public List<Escuelas> readEscuelasTipo(int tipo);


    //::::::::::Actualizacion de metodos
}
