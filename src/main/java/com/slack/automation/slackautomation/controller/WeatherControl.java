package com.slack.automation.slackautomation.controller;

import com.slack.automation.slackautomation.handler.WeatherHandler;
import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherControl {

    private Logger logger = Logger.getLogger(this.getClass());

    @RequestMapping("/weather")
    @ResponseBody
    public String getWeather(HttpEntity<String> httpEntity) {
        String[] payload = httpEntity.getBody().split("&");
        String city = "";
        for (String c : payload) {
            if (c.contains("text=")) {
                city = c;
                break;
            }
        }
        WeatherHandler w = new WeatherHandler(city.substring(5));
        return w.getContent();
    }
}
