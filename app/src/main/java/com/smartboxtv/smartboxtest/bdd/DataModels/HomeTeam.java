
package com.smartboxtv.smartboxtest.bdd.DataModels;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeTeam implements Serializable
{

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("shortName")
    @Expose
    private String shortName;
    private final static long serialVersionUID = -1219186537482950277L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public HomeTeam() {
    }

    /**
     * 
     * @param id
     * @param name
     * @param shortName
     */
    public HomeTeam(String id, String name, String shortName) {
        super();
        this.id = id;
        this.name = name;
        this.shortName = shortName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

}
