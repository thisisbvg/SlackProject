package com.slack.automation.slackautomation.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "type",
        "user",
        "item",
        "reaction",
        "event_ts"
})
public class Event {

    @JsonProperty("type")
    private String type;
    @JsonProperty("user")
    private String user;
    @JsonProperty("item")
    private Item item;
    @JsonProperty("reaction")
    private String reaction;
    @JsonProperty("event_ts")
    private String eventTs;

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("user")
    public String getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(String user) {
        this.user = user;
    }

    @JsonProperty("item")
    public Item getItem() {
        return item;
    }

    @JsonProperty("item")
    public void setItem(Item item) {
        this.item = item;
    }

    @JsonProperty("reaction")
    public String getReaction() {
        return reaction;
    }

    @JsonProperty("reaction")
    public void setReaction(String reaction) {
        this.reaction = reaction;
    }

    @JsonProperty("event_ts")
    public String getEventTs() {
        return eventTs;
    }

    @JsonProperty("event_ts")
    public void setEventTs(String eventTs) {
        this.eventTs = eventTs;
    }

}
