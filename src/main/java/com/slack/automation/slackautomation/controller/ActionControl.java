package com.slack.automation.slackautomation.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.slack.automation.slackautomation.model.Reaction;
import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
public class ActionControl {

    private Logger logger = Logger.getLogger(this.getClass());

    @RequestMapping(value = "/actions", produces = "application/json")
    @ResponseBody
    public void getActions(HttpEntity<String> httpEntity) throws IOException {

        logger.info(httpEntity.getBody());
        logger.info(httpEntity.getBody());
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        JsonObject object = (JsonObject) parser.parse(String.valueOf(httpEntity.getBody()));
        Reaction reaction = gson.fromJson(object, Reaction.class);
        if (reaction.getEvent().getReaction().equals("+1::skin-tone-4")) {
            logger.info("inside");

            URL urlObj = new URL("https://hooks.slack.com/services/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");
            HttpURLConnection httpCon = (HttpURLConnection) urlObj.openConnection();
            httpCon.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            httpCon.setRequestProperty("Accept", "application/json");
            httpCon.setConnectTimeout(5000);
            httpCon.setDoOutput(true);
            httpCon.setRequestMethod("POST");

            String json = "{'text':'Message liked'}";

            DataOutputStream wr = new DataOutputStream(httpCon.getOutputStream());
            wr.writeBytes(json);
            wr.flush();
            wr.close();
            int responseCode = httpCon.getResponseCode();
            logger.info("nSending 'POST' request to URL : " + urlObj);
            logger.info("Post Data : " + json);
            logger.info("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(httpCon.getInputStream()));
            String output;
            StringBuilder response = new StringBuilder();

            while ((output = in.readLine()) != null) {
                response.append(output);
            }
            in.close();

            //printing result from response
            logger.info(response.toString());
        }

    }

}
