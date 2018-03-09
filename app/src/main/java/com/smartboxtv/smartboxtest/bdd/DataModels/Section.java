
package com.smartboxtv.smartboxtest.bdd.DataModels;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Section implements Serializable
{

    @SerializedName("index")
    @Expose
    private long index;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private Title title;
    private final static long serialVersionUID = -1355842525567369871L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Section() {
    }

    /**
     * 
     * @param id
     * @param title
     * @param index
     */
    public Section(long index, String id, Title title) {
        super();
        this.index = index;
        this.id = id;
        this.title = title;
    }

    public long getIndex() {
        return index;
    }

    public void setIndex(long index) {
        this.index = index;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

}
