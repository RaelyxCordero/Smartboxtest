
package com.smartboxtv.smartboxtest.bdd.DataModels;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data implements Serializable
{

    @SerializedName("sections")
    @Expose
    private ArrayList<Section> sections = new ArrayList<>();
    @SerializedName("items")
    @Expose
    private ArrayList<Item> items = new ArrayList<>();
    @SerializedName("pagination")
    @Expose
    private Pagination pagination;

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
    public Data(ArrayList<Section> sections, ArrayList<Item> items, Pagination pagination) {
        super();
        this.sections = sections;
        this.items = items;
        this.pagination = pagination;
    }

    public ArrayList<Section> getSections() {
        return sections;
    }

    public void setSections(ArrayList<Section> sections) {
        this.sections = sections;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    @Override
    public String toString() {
        return "Data{" +
                "sections=" + sections +
                ", items=" + items +
                ", pagination=" + pagination +
                '}';
    }
}
