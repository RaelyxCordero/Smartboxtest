
package com.smartboxtv.smartboxtest.bdd.DataModels;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data implements Serializable
{

    @SerializedName("sections")
    @Expose
    private List<Section> sections = null;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;
    @SerializedName("pagination")
    @Expose
    private Pagination pagination;
    private final static long serialVersionUID = -7956161448471880463L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Data() {
    }

    /**
     * 
     * @param sections
     * @param items
     * @param pagination
     */
    public Data(List<Section> sections, List<Item> items, Pagination pagination) {
        super();
        this.sections = sections;
        this.items = items;
        this.pagination = pagination;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

}
