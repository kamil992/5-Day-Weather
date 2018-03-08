package pl.kamilbiernacki.springWeather.models.services;

import org.json.JSONArray;
import org.json.JSONObject;
import pl.kamilbiernacki.springWeather.models.Utils;
import pl.kamilbiernacki.springWeather.models.WeatherModel;


public class WeatherService {

    private static WeatherService ourInstance = new WeatherService();

    public static WeatherService getInstance() {
        return ourInstance;
    }

    private WeatherService() {
    }

    public WeatherModel getWeather(String city) {

        String websiteResponse = Utils.readWebsiteContent("http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=52a68fc2733794ec8e5f76eccf3b2480");
        String description = null;
        int temperature;
        int pressure;
        int humidity;
        int clouds;

        JSONObject root = new JSONObject(websiteResponse);

        JSONArray weatherObject = root.getJSONArray("weather");

        for (int i = 0; i < weatherObject.length(); i++) {
            JSONObject elementInArray = weatherObject.getJSONObject(i);
            description = elementInArray.getString("description");
        }

        JSONObject main = root.getJSONObject("main");
        //obiekty main z json
        temperature = (int) main.getFloat("temp") - 273;
        pressure = main.getInt("pressure");
        humidity = main.getInt("humidity");

        JSONObject mainOb = root.getJSONObject("clouds");
        clouds = mainOb.getInt("all");

        WeatherModel weatherModel = new WeatherModel();
        weatherModel.setCity(city);
        weatherModel.setClouds(clouds);
        weatherModel.setHumidity(humidity);
        weatherModel.setPressure(pressure);
        weatherModel.setTemperature(temperature);
        weatherModel.setWeatherComment(description);

        return weatherModel;
    }
}