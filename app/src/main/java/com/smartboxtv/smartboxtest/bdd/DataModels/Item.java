
package com.smartboxtv.smartboxtest.bdd.DataModels;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item implements Serializable
{

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("__belong")
    @Expose
    private Belong belong;
    @SerializedName("_externalProvider")
    @Expose
    private String externalProvider;
    @SerializedName("_externalId")
    @Expose
    private String externalId;
    @SerializedName("matchDay")
    @Expose
    private MatchDay matchDay;
    @SerializedName("eventStatus")
    @Expose
    private EventStatus eventStatus;
    @SerializedName("statusCategory")
    @Expose
    private String statusCategory;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("startDate")
    @Expose
    private String startDate;
    @SerializedName("cellType")
    @Expose
    private long cellType;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("homeTeam")
    @Expose
    private HomeTeam homeTeam;
    @SerializedName("awayTeam")
    @Expose
    private AwayTeam awayTeam;
    @SerializedName("homeScore")
    @Expose
    private long homeScore;
    @SerializedName("awayScore")
    @Expose
    private long awayScore;
    @SerializedName("matchTime")
    @Expose
    private long matchTime;
    @SerializedName("homePenalties")
    @Expose
    private Object homePenalties;
    @SerializedName("awayPenalties")
    @Expose
    private Object awayPenalties;
    @SerializedName("endDate")
    @Expose
    private String endDate;
    @SerializedName("statusDate")
    @Expose
    private String statusDate;
    @SerializedName("_createDate")
    @Expose
    private String createDate;
    @SerializedName("__children")
    @Expose
    private Children children;
    @SerializedName("_model")
    @Expose
    private String model;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Item() {
    }

    public Item(String id, Belong belong, String externalProvider, String externalId, MatchDay matchDay, EventStatus eventStatus, String statusCategory, Location location, String startDate, long cellType, String type, HomeTeam homeTeam, AwayTeam awayTeam, long homeScore, long awayScore, long matchTime, Object homePenalties, Object awayPenalties, String endDate, String statusDate, String createDate, Children children, String model) {
        super();
        this.id = id;
        this.belong = belong;
        this.externalProvider = externalProvider;
        this.externalId = externalId;
        this.matchDay = matchDay;
        this.eventStatus = eventStatus;
        this.statusCategory = statusCategory;
        this.location = location;
        this.startDate = startDate;
        this.cellType = cellType;
        this.type = type;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.matchTime = matchTime;
        this.homePenalties = homePenalties;
        this.awayPenalties = awayPenalties;
        this.endDate = endDate;
        this.statusDate = statusDate;
        this.createDate = createDate;
        this.children = children;
        this.model = model;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Belong getBelong() {
        return belong;
    }

    public void setBelong(Belong belong) {
        this.belong = belong;
    }

    public String getExternalProvider() {
        return externalProvider;
    }

    public void setExternalProvider(String externalProvider) {
        this.externalProvider = externalProvider;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public MatchDay getMatchDay() {
        return matchDay;
    }

    public void setMatchDay(MatchDay matchDay) {
        this.matchDay = matchDay;
    }

    public EventStatus getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(EventStatus eventStatus) {
        this.eventStatus = eventStatus;
    }

    public String getStatusCategory() {
        return statusCategory;
    }

    public void setStatusCategory(String statusCategory) {
        this.statusCategory = statusCategory;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public long getCellType() {
        return cellType;
    }

    public void setCellType(long cellType) {
        this.cellType = cellType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public HomeTeam getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(HomeTeam homeTeam) {
        this.homeTeam = homeTeam;
    }

    public AwayTeam getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(AwayTeam awayTeam) {
        this.awayTeam = awayTeam;
    }

    public long getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(long homeScore) {
        this.homeScore = homeScore;
    }

    public long getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(long awayScore) {
        this.awayScore = awayScore;
    }

    public long getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(long matchTime) {
        this.matchTime = matchTime;
    }

    public Object getHomePenalties() {
        return homePenalties;
    }

    public void setHomePenalties(Object homePenalties) {
        this.homePenalties = homePenalties;
    }

    public Object getAwayPenalties() {
        return awayPenalties;
    }

    public void setAwayPenalties(Object awayPenalties) {
        this.awayPenalties = awayPenalties;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(String statusDate) {
        this.statusDate = statusDate;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Children getChildren() {
        return children;
    }

    public void setChildren(Children children) {
        this.children = children;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", belong=" + belong +
                ", externalProvider='" + externalProvider + '\'' +
                ", externalId='" + externalId + '\'' +
                ", matchDay=" + matchDay +
                ", eventStatus=" + eventStatus +
                ", statusCategory='" + statusCategory + '\'' +
                ", location=" + location +
                ", startDate='" + startDate + '\'' +
                ", cellType=" + cellType +
                ", type='" + type + '\'' +
                ", homeTeam=" + homeTeam +
                ", awayTeam=" + awayTeam +
                ", homeScore=" + homeScore +
                ", awayScore=" + awayScore +
                ", matchTime=" + matchTime +
                ", homePenalties=" + homePenalties +
                ", awayPenalties=" + awayPenalties +
                ", endDate='" + endDate + '\'' +
                ", statusDate='" + statusDate + '\'' +
                ", createDate='" + createDate + '\'' +
                ", children=" + children +
                ", model='" + model + '\'' +
                '}';
    }
}
