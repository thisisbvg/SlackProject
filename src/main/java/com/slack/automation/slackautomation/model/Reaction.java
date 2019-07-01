package com.slack.automation.slackautomation.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "token",
        "team_id",
        "api_app_id",
        "event",
        "type",
        "event_id",
        "event_time",
        "authed_users"
})
public class Reaction {

    @JsonProperty("token")
    private String token;
    @JsonProperty("team_id")
    private String teamId;
    @JsonProperty("api_app_id")
    private String apiAppId;
    @JsonProperty("event")
    private Event event;
    @JsonProperty("type")
    private String type;
    @JsonProperty("event_id")
    private String eventId;
    @JsonProperty("event_time")
    private Integer eventTime;
    @JsonProperty("authed_users")
    private List<String> authedUsers = null;

    @JsonProperty("token")
    public String getToken() {
        return token;
    }

    @JsonProperty("token")
    public void setToken(String token) {
        this.token = token;
    }

    @JsonProperty("team_id")
    public String getTeamId() {
        return teamId;
    }

    @JsonProperty("team_id")
    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    @JsonProperty("api_app_id")
    public String getApiAppId() {
        return apiAppId;
    }

    @JsonProperty("api_app_id")
    public void setApiAppId(String apiAppId) {
        this.apiAppId = apiAppId;
    }

    @JsonProperty("event")
    public Event getEvent() {
        return event;
    }

    @JsonProperty("event")
    public void setEvent(Event event) {
        this.event = event;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("event_id")
    public String getEventId() {
        return eventId;
    }

    @JsonProperty("event_id")
    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    @JsonProperty("event_time")
    public Integer getEventTime() {
        return eventTime;
    }

    @JsonProperty("event_time")
    public void setEventTime(Integer eventTime) {
        this.eventTime = eventTime;
    }

    @JsonProperty("authed_users")
    public List<String> getAuthedUsers() {
        return authedUsers;
    }

    @JsonProperty("authed_users")
    public void setAuthedUsers(List<String> authedUsers) {
        this.authedUsers = authedUsers;
    }

}
