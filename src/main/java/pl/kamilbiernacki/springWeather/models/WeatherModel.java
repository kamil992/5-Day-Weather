package pl.kamilbiernacki.springWeather.models;


import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class WeatherModel {

    private String city;
    private String date;
    private int temperature;
    private int pressure;
    private int humidity;
    private int clouds;
    private String weatherComment;
}
