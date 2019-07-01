package com.slack.automation.slackautomation.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class ImageControl {

    private static final String template = "Hello, %s!";
    String resp = "{ 'response_type': 'in_channel' ,'text': '302: Found','attachments':[ {'image_url': 'https://http.cat/302.jpg'} ]}";
    private Logger logger = Logger.getLogger(this.getClass());

    public String getARandomCard() {
        String cardValue[] = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "ace", "jack", "king", "queen_"};
        String suit[] = new String[]{"hearts", "clubs", "spades", "diamonds"};
        Random cardVal = new Random();
        Random suitCard = new Random();
        return cardValue[cardVal.nextInt(cardValue.length)] + "_of_" + suit[suitCard.nextInt(suit.length)];
    }

    @RequestMapping(value = "/image")
    public @ResponseBody
    String getFile() {
        String randomVal = getARandomCard();
        return "{ 'response_type': 'in_channel' ,'text': 'Random generated card','attachments':[ {'image_url': 'https://allcards.s3.us-east-2.amazonaws.com/" + randomVal + ".png'} ]}";

    }

}
