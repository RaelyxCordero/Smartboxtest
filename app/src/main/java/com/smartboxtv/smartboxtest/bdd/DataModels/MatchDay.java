
package com.smartboxtv.smartboxtest.bdd.DataModels;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MatchDay implements Serializable
{

    @SerializedName("start")
    @Expose
    private String start;
    @SerializedName("end")
    @Expose
    private String end;
    @SerializedName("name")
    @Expose
    private NameMatchDay nameMatchDay;
    @SerializedName("phase")
    @Expose
    private Phase phase;

    /**
     * No args constructor for use in serialization
     * 
     */
    public MatchDay() {
    }

    /**
     * 
     * @param start
     * @param nameMatchDay
     * @param phase
     * @param end
     */
    public MatchDay(String start, String end, NameMatchDay nameMatchDay, Phase phase) {
        super();
        this.start = start;
        this.end = end;
        this.nameMatchDay = nameMatchDay;
        this.phase = phase;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public NameMatchDay getNameMatchDay() {
        return nameMatchDay;
    }

    public void setNameMatchDay(NameMatchDay nameMatchDay) {
        this.nameMatchDay = nameMatchDay;
    }

    public Phase getPhase() {
        return phase;
    }

    public void setPhase(Phase phase) {
        this.phase = phase;
    }

    @Override
    public String toString() {
        return "MatchDay{" +
                "start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", nameMatchDay=" + nameMatchDay +
                ", phase=" + phase +
                '}';
    }
}
