
package com.smartboxtv.smartboxtest.bdd.DataModels;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Children implements Serializable
{

    @SerializedName("TimeLine")
    @Expose
    private List<String> timeLine = null;
    @SerializedName("Formation")
    @Expose
    private List<String> formation = null;
    private final static long serialVersionUID = -3949768560854931500L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Children() {
    }

    /**
     * 
     * @param timeLine
     * @param formation
     */
    public Children(List<String> timeLine, List<String> formation) {
        super();
        this.timeLine = timeLine;
        this.formation = formation;
    }

    public List<String> getTimeLine() {
        return timeLine;
    }

    public void setTimeLine(List<String> timeLine) {
        this.timeLine = timeLine;
    }

    public List<String> getFormation() {
        return formation;
    }

    public void setFormation(List<String> formation) {
        this.formation = formation;
    }

}
