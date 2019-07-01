package com.slack.automation.slackautomation.handler;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.slack.automation.slackautomation.model.WeatherModel;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class WeatherHandler {

    private final String city;
    private Logger logger = Logger.getLogger(this.getClass());

    public WeatherHandler(String city) {
        this.city = city;
    }

    public String getContent() {
        StringBuffer response = new StringBuffer();
        try {
            String token = "b6907d289e10d714a6e88b30761fae22";
            String city = URLEncoder.encode(this.city, "UTF-8");
            String buildUrl = "https://openweathermap.org/data/2.5/weather?q=" + city + ",US&appid=" + token;
            URL url = new URL(buildUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            logger.info("\nSending 'GET' request to URL : " + url);
            logger.info("Response Code : " + responseCode);
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            logger.info("Response Code : " + response);
            in.close();

        }
        catch(ConnectException connectException) {
            connectException.printStackTrace();
        } catch(IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        JsonObject object = (JsonObject) parser.parse(String.valueOf(response));
        WeatherModel weather = gson.fromJson(object, WeatherModel.class);

        return "WeatherHandler in " + this.city.replace("+", " ") + " is: " + weather.getMain().getTemp().toString() + " degree C";
    }
}
