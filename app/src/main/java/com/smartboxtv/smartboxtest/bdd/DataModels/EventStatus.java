
package com.smartboxtv.smartboxtest.bdd.DataModels;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EventStatus implements Serializable
{

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private Name name;
    @SerializedName("category")
    @Expose
    private String category;
    private final static long serialVersionUID = 3092885998299906340L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public EventStatus() {
    }

    /**
     * 
     * @param id
     * @param category
     * @param name
     */
    public EventStatus(String id, Name name, String category) {
        super();
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
