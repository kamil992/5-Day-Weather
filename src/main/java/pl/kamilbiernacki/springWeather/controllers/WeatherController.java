package pl.kamilbiernacki.springWeather.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.ResponseBody;
import pl.kamilbiernacki.springWeather.models.services.WeatherService;

import java.util.Date;

@Controller
public class WeatherController {

    @GetMapping("/weather")
    public String getWeather(){
        return "weather";
    }

    @PostMapping("/weather")
    @ResponseBody
    public String postWeather(@RequestParam("city") String city){
        WeatherService weatherService = WeatherService.getInstance();
        //System.out.println(weatherService.getWeather(city));

        String todayWeather = String.valueOf(weatherService.getWeather(city));


        return new Date()+ " || "+todayWeather;
    }
}
