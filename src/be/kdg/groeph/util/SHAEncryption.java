package be.kdg.groeph.util;


import com.sun.jersey.core.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

public final class SHAEncryption {

    public static String encrypt(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(password.getBytes("UTF-8"));
            byte byteData[] = md.digest();
            String str = new String(new Base64().encode(byteData), "UTF8");
            str = str.replaceAll("=","1");
            str = str.replaceAll("/","2");
            str = str.replaceAll("\\+","3");
            str = str.replaceAll(Pattern.quote("\\"),"4");
            return str;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Algorithm not found", e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Encoding not supported", e);
        }
    }
}
