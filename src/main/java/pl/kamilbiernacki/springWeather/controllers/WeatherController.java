package pl.kamilbiernacki.springWeather.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import pl.kamilbiernacki.springWeather.models.WeatherModel;
import pl.kamilbiernacki.springWeather.models.services.WeatherService;

import java.util.Date;
import java.util.Optional;

@Controller
public class WeatherController {


    @GetMapping("/weather")
    public String getWeather(){
        return "weather";
    }

    @PostMapping("/weather")
    public String postWeather(@RequestParam("city") String city,
                              Model model){


        if(city.length() == 0){
            return "weather";
        }

        WeatherService weatherService = WeatherService.getInstance();


        model.addAttribute("cityName", weatherService.getWeather(city));

        model.addAttribute("cityWeather",weatherService.getWeatherForFive(city));

        return "cityweather";

    }
}
