
package com.smartboxtv.smartboxtest.bdd.DataModels;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pagination implements Serializable
{

    @SerializedName("page")
    @Expose
    private int page;
    @SerializedName("first")
    @Expose
    private int first;
    @SerializedName("items")
    @Expose
    private int items;
    @SerializedName("last")
    @Expose
    private int last;
    @SerializedName("next")
    @Expose
    private int next;
    @SerializedName("pages")
    @Expose
    private int pages;
    @SerializedName("offset")
    @Expose
    private int offset;
    @SerializedName("totalItems")
    @Expose
    private int totalItems;

    public Pagination() {
    }


    public Pagination(int page, int first, int items, int last, int next, int pages,
                      int offset, int totalItems) {
        super();
        this.page = page;
        this.first = first;
        this.items = items;
        this.last = last;
        this.next = next;
        this.pages = pages;
        this.offset = offset;
        this.totalItems = totalItems;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

}
