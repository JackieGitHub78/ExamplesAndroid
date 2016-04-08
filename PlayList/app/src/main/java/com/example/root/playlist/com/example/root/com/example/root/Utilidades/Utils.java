package com.example.root.playlist.com.example.root.com.example.root.Utilidades;



import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by root on 15/02/16.
 */
public class Utils {

    private static final String ALGORITMO = "AES/CBC/PKCS5Padding";

    public static String decrypt(String encodedInitialData, String key)
            throws InvalidKeyException, IllegalBlockSizeException,
            BadPaddingException, UnsupportedEncodingException,
            NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidAlgorithmParameterException, DecoderException {


        byte[] encryptedData = Base64.decodeBase64(encodedInitialData.getBytes());//org.apache.commons.codec.binary.Hex.decodeHex(encodedInitialData.toCharArray());
        //DatatypeConverter.parseBase64Binary(encodedInitialData);

        byte[] raw = org.apache.commons.codec.binary.Hex.decodeHex(key.toCharArray());
        //1DatatypeConverter.parseHexBinary(key);


        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance(ALGORITMO);

        byte[] iv = Arrays.copyOfRange(encryptedData, 0, 16);

        byte[] cipherText = Arrays.copyOfRange(encryptedData, 16,
                encryptedData.length);
        IvParameterSpec iv_specs = new IvParameterSpec(iv);

        cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv_specs);

        byte[] plainTextBytes = cipher.doFinal(cipherText);
        String plainText = new String(plainTextBytes);

        return plainText;
    }

    //metodo para comprobar si ya se decargp eñ cual recibe como parametros el nombre y la catividad
    //what is context in android Studio ?
    /*As the name suggests, its the context of current state of the application/object. It lets newly created objects understand what has been going on. Typically you call it to get information regarding another part of your program (activity, package/application)
    You can get the context by invoking getApplicationContext(), getContext(), getBaseContext() or this (when in the activity class).*/

    //mandamos como parametro el nombre y el contexto que se refiere a la actividad o lo que esta oacurriendo en ese momento en la apllicacion o en un objeto

    public static boolean ValidarDescarga(String nombre, Context context) {

        //Las preferencias en android no son más que datos que una aplicación debe guardar para personalizar la experiencia del usuario
        SharedPreferences prefs = context.getSharedPreferences("MIB", Context.MODE_PRIVATE);
        //hacemos una variable de tipo prefernecias compratidas: Para obtener una referencia a una colección determinada utilizaremos el método getSharedPrefences() al que pasaremos el identificador de la colección y un modo de acceso.
        //le decimos que se encuentra en la "carpeta MINB" y que solo tiene acceso nuestra aplicacion a esto
        SharedPreferences.Editor editor = prefs.edit();
        /*Para actualizar o insertar nuevas preferencias el proceso será igual de sencillo, con la única diferencia de que la actualización o inserción no la haremos directamente sobre el objeto SharedPreferences, sino sobre su objeto de edición SharedPreferences.Editor. A este último objeto accedemos mediante el método edit() de la clase SharedPreferences. */
        int valor = prefs.getInt(nombre, 0);
        /*le pasamos el nombre de la preferencia que queremos recuperar y un segundo parámetro con un valor por defecto. Este valor por defecto será el devuelto por el método getIng() si la preferencia solicitada no existe en la colección.*/
        if (valor > 0)
            //preguntamos si el valor existe o el m¡nomnbre si valor es mayo a cero regresa un false de lo contrario un true
            return false;
        else
            return true;

    }

    public static void mostrarAlerta(final Activity actividad, String titulo, String mensaje)
    {
        AlertDialog alerta = new AlertDialog.Builder(actividad).create();
        alerta.setTitle(titulo);
        alerta.setMessage(mensaje);
        alerta.setCancelable(false);
        alerta.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(final DialogInterface dialog, final int which) {
                dialog.cancel();
                actividad.finish();
                System.exit(0);
                System.gc();
            }
        });
        alerta.setMessage(mensaje);

        alerta.show();
    }
}
