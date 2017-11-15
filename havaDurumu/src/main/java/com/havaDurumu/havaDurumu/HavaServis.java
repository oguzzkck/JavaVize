package com.havaDurumu.havaDurumu;

import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class HavaServis {

    RestTemplate restTemplate;
    HavaD weather;

    public String sayHello(String name){
        return "Hello " + name;
    }

    public HavaD getWeather(String city){

        restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new FormHttpMessageConverter());
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        weather = restTemplate.getForObject("http://api.openweathermap.org/data/2.5/weather?q=" + city + "&APPID=d71bf9828a75d362d858d04df4c6e1e6", HavaD.class);

        return weather;
    }

    public HavaD getWeather(){
        return this.weather;
    }
}