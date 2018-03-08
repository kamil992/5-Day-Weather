package pl.kamilbiernacki.springWeather.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.kamilbiernacki.springWeather.models.WeatherModel;
import pl.kamilbiernacki.springWeather.models.services.WeatherService;

@Controller
public class WeatherController {

    @GetMapping("/weather")
    public String getWeagfdrther(){
        return "weather";
    }

    @PostMapping("/weather")
    public String postWeather(@RequestParam("city") String city){
        WeatherService weatherService = WeatherService.getInstance();
        System.out.println(weatherService.getWeather(city));
        return "weather";
    }
}
