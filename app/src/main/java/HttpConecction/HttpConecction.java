package HttpConecction;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by TecnoSystem on 20/04/2017.
 */

public class HttpConecction {

    public String enviarDatosGet(String enlace) {
        String linea;
        int respuesta;

        StringBuilder result = null;
        try {
            URL url = new URL(enlace);

            HttpURLConnection conection = (HttpURLConnection) url.openConnection();

            respuesta = conection.getResponseCode();

            result = new StringBuilder();

            if (respuesta == HttpURLConnection.HTTP_OK) {

                InputStream in = new BufferedInputStream(conection.getInputStream());

                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                while ((linea = reader.readLine()) != null) {
                    result.append(linea);
                }
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }

}
