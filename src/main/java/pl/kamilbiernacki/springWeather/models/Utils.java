package pl.kamilbiernacki.springWeather.models;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Utils {
    public static String readWebsiteContent(String url){

        StringBuilder stringBuilder = new StringBuilder();

        try {
            HttpURLConnection urlConnection = (HttpURLConnection) new URL(url).openConnection();
            InputStream content = urlConnection.getInputStream();// kod bajt po bajcie dlatego integer

            int read = 0;
            while((read = content.read()) != -1){
                stringBuilder.append((char)read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
