package com.slack.automation.slackautomation.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "type",
        "channel",
        "ts"
})
public class Item {

    @JsonProperty("type")
    private String type;
    @JsonProperty("channel")
    private String channel;
    @JsonProperty("ts")
    private String ts;

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("channel")
    public String getChannel() {
        return channel;
    }

    @JsonProperty("channel")
    public void setChannel(String channel) {
        this.channel = channel;
    }

    @JsonProperty("ts")
    public String getTs() {
        return ts;
    }

    @JsonProperty("ts")
    public void setTs(String ts) {
        this.ts = ts;
    }

}
