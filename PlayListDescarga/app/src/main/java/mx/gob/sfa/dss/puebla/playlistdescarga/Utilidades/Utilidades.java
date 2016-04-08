package mx.gob.sfa.dss.puebla.playlistdescarga.Utilidades;

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
 * Created by dtit on 07/04/16.
 */
public class Utilidades {

    private static final String ALGORITMO = "AES/CBC/PKCS5Padding";

    public static String decrypt(String encodedInitialData, String key)
            throws InvalidKeyException, IllegalBlockSizeException,
            BadPaddingException, UnsupportedEncodingException,
            NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidAlgorithmParameterException, DecoderException {


        //los nombres y la url de las canciones que estan en el servicio vienen encriptadas entonces usamos este metodo para
        //desencriptar la informacion antes de ser insertada en la base de datos....


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
}
