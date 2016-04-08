package com.example.root.playlist.com.example.root.Servicios;

import android.app.Activity;

import com.example.root.playlist.com.example.root.Entidades.Audio;
import com.example.root.playlist.com.example.root.com.example.root.Utilidades.Utils;
import com.example.root.playlist.com.example.root.layout.Textos;

import org.apache.commons.codec.DecoderException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * Created by root on 14/02/16.
 */
public class Servicios {

    //declaramos esta variable para poder mandale un mensje al usuario a un activiti que es la prate vizual que
    //que vizualiza el usuario
    private Activity activity;
    //variable que almacena SOAPAction: "http://tempuri.org/Datos" que se encuentra en el servicio de soap
    private static final String NAMESPACE = "http://tempuri.org/";
    //url de donde se encuentra el servicio SOAP
    private static final String URL = "http://servicios.sfapuebla.gob.mx/rsMuseo/rsMBarroco.asmx";//http://servicios.sfapuebla.gob.mx/wsOrdenDeCobro/Service1.asmx";

    public List<Audio> getAllSound(int sala, int idioma,final Activity activity)
    {

        //creamos la lista qe se va a llenar con la informacion
        List<Audio> listaAudio = new ArrayList<Audio>();
        //este metodo es el que se ocupa para recibir los datos para l aplay list, drecibe tres parametros, ya q eel servicio
        //que se ocupa recibe el id de la sala y el idioma para ppoder regresar datos

        String METHOD = "Datos"; //nombre del servicio qe estamos ocupando
        //para poder ocupar el SoapObject tenemos que tener las dependencias en eñl gradle
        SoapObject peticion = new SoapObject(NAMESPACE, METHOD);
        //le asignamos a la variable los paramtros para hacer la peticionenviandole SOAPAction y el metodo que ocuparemos del servicio
        peticion.addProperty("idSala", sala);
        peticion.addProperty("idIdioma", idioma);
        //mandamos los parametros

        String temp="";
        //serizacion de datos, por el tema de ksoap
        SoapSerializationEnvelope sobre = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);

        //con este espeficicamos que es de .net
        sobre.dotNet = true;
        //aqui se asigna la varible para hacer la peticion
        sobre.setOutputSoapObject(peticion);
        //el medio de trasporte por el cual se va estar ocupando el servicio y le asignamos la url del servico
        HttpTransportSE transporte = new HttpTransportSE(URL);

        try {
            transporte.call(NAMESPACE + METHOD, sobre);
            //aqui estas indicando como es que se van a ir los datos
            SoapObject resultado = (SoapObject) sobre.getResponse();
            //n aqui es donde hacemos la peticion

            //preguntamos si la respuesta es diferente de null
            if (resultado != null)
            {
                String res  = resultado.getProperty(0).toString();
                // aqui le indicamos que queremos toda la lista de objetos por ejemplo si viniera
                //potra liosta debajo de ese elemto seria getProperty(1) o 2 o 3 dependiendo
                JSONArray array = new JSONArray(res);
                //aqui convertimos la respuest en un arreglo de JSON


                //recorremos el array
                for (int i = 0; i < array.length(); i++)
                {
                    //obtiene la infromacion la cual esta en objetos dependiendo de la posicion
                    JSONObject object = array.getJSONObject(i);

                    String sound = Utils.decrypt(object.getString("URL"), "605bd70efed2c6374823b54bbc560b58");
                    String nombre = Utils.decrypt(object.getString("Nombre"), "605bd70efed2c6374823b54bbc560b58");
                    int idAudio = object.getInt("IdAudio");
                    int idIdioma = object.getInt("Idioma");
                    String duracion = object.getString("Duracion");

                    //vamos a deacargar por id
                    temp = String.valueOf(idAudio);
                    //namos la lista de acuerdo a la entidad
                    listaAudio.add(new Audio(idAudio,idIdioma,nombre,sound,duracion, Utils.ValidarDescarga(temp, activity.getApplicationContext())));


                }
            }
            else{
                return  null;
            }

        } catch (IOException e) {
            //mesaje por si la conexion de pierde
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Utils.mostrarAlerta(activity,"MUSEO INTENACIONAL DEL BARROCO", Textos.Texto.conexionInternet);
                }
            });

            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (DecoderException e) {
            e.printStackTrace();
        }


        return listaAudio;
    }

}
