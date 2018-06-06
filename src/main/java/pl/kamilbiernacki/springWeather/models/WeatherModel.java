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

    public WeatherModel(Builder builder){
        this.city = builder.city;
        this.date = builder.date;
        this.temperature = builder.temperature;
        this.pressure = builder.pressure;
        this.humidity = builder.humidity;
        this.clouds = builder.clouds;
        this.weatherComment = builder.weatherComment;
    }


    public static class Builder{

        private String city;
        private String date;
        private int temperature;
        private int pressure;
        private int humidity;
        private int clouds;
        private String weatherComment;

        public Builder(String city){
            this.city = city;
        }

        public String getCity() {
            return city;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public String getDate() {
            return date;
        }

        public Builder setDate(String date) {
            this.date = date;
            return this;
        }

        public int getTemperature() {
            return temperature;
        }

        public Builder setTemperature(int temperature) {
            this.temperature = temperature;
            return this;
        }

        public int getPressure() {
            return pressure;
        }

        public Builder setPressure(int pressure) {
            this.pressure = pressure;
            return this;
        }

        public int getHumidity() {
            return humidity;
        }

        public Builder setHumidity(int humidity) {
            this.humidity = humidity;
            return this;
        }

        public int getClouds() {
            return clouds;
        }

        public Builder setClouds(int clouds) {
            this.clouds = clouds;
            return this;
        }

        public String getWeatherComment() {
            return weatherComment;
        }

        public Builder setWeatherComment(String weatherComment) {
            this.weatherComment = weatherComment;
            return this;
        }

        public WeatherModel build(){
            return new WeatherModel(this);
        }
    }
}
