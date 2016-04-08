package mx.gob.sfa.dss.puebla.playlistdescarga.Servicios;

import android.app.Activity;
import android.util.Log;

import org.apache.commons.codec.DecoderException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpResponseException;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import mx.gob.sfa.dss.puebla.playlistdescarga.Entidades.Auidos;
import mx.gob.sfa.dss.puebla.playlistdescarga.Metodos.Metodos;
import mx.gob.sfa.dss.puebla.playlistdescarga.Utilidades.Utilidades;

/**
 * Created by dtit on 06/04/16.
 */
public class Servicio  {

    //Entidad audio
    Auidos audios2;
    Metodos mdb;

    private Activity activity;
    private static final String NAMESPACE = "http://tempuri.org/";
    private static final String URL = "http://servicios.sfapuebla.gob.mx/rsMuseo/rsMBarroco.asmx";//http://servicios.sfapuebla.gob.mx/wsOrdenDeCobro/Service1.asmx"; //ur del servicio

    public void getalsounds(final Activity activity, final RealmConfiguration realmConfig)
    {
        String METHOD = "DatosTmp";
        SoapObject peticion = new SoapObject(NAMESPACE, METHOD);
        SoapSerializationEnvelope sobre = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        sobre.dotNet = true;
        sobre.setOutputSoapObject(peticion);
        HttpTransportSE transporte = new HttpTransportSE(URL);
        try {
            transporte.call(NAMESPACE + METHOD, sobre);
            SoapObject resultado = (SoapObject) sobre.getResponse();
            mdb = new Metodos(realmConfig); //objeto de  los metodos de la base de datos
            audios2 = new Auidos(); //entidad audios
            if(resultado !=null)
            {
                String res = resultado.getProperty(0).toString();
                JSONArray array = new JSONArray(res);

                for(int i = 0; i<array.length(); i++)
                {
                    JSONObject object = array.getJSONObject(i);
                    Log.e("id", "es: " + object.getInt("IdAudio"));
                    //add elements to bd
                    audios2.setIdAudio(object.getInt("IdAudio"));
                    audios2.setIdIdioma(object.getInt("Idioma"));
                    audios2.setIdSala(object.getInt("idSala"));
                    audios2.setDuracion(object.getString("Duracion"));
                    audios2.setNombreAudio(Utilidades.decrypt(object.getString("Nombre"), "605bd70efed2c6374823b54bbc560b58"));
                    audios2.setUrlAudio(Utilidades.decrypt(object.getString("URL"), "605bd70efed2c6374823b54bbc560b58"));
                    audios2.setDescarga(0);
                    mdb.addAudios(audios2);

                }

                Log.e("","tiene");
            }else
            {
                Log.e("","no tiene");
            }

        } catch (SoapFault soapFault) {
            soapFault.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (HttpResponseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (DecoderException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }


    }

}
