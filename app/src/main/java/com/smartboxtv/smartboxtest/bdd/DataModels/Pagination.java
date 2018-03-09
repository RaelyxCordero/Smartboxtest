
package com.smartboxtv.smartboxtest.bdd.DataModels;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pagination implements Serializable
{

    @SerializedName("page")
    @Expose
    private long page;
    @SerializedName("first")
    @Expose
    private long first;
    @SerializedName("items")
    @Expose
    private long items;
    @SerializedName("last")
    @Expose
    private long last;
    @SerializedName("next")
    @Expose
    private long next;
    @SerializedName("pages")
    @Expose
    private long pages;
    @SerializedName("offset")
    @Expose
    private long offset;
    @SerializedName("totalItems")
    @Expose
    private long totalItems;
    private final static long serialVersionUID = 2448290062050790830L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Pagination() {
    }

    /**
     * 
     * @param last
     * @param items
     * @param page
     * @param pages
     * @param next
     * @param totalItems
     * @param offset
     * @param first
     */
    public Pagination(long page, long first, long items, long last, long next, long pages, long offset, long totalItems) {
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

    public long getPage() {
        return page;
    }

    public void setPage(long page) {
        this.page = page;
    }

    public long getFirst() {
        return first;
    }

    public void setFirst(long first) {
        this.first = first;
    }

    public long getItems() {
        return items;
    }

    public void setItems(long items) {
        this.items = items;
    }

    public long getLast() {
        return last;
    }

    public void setLast(long last) {
        this.last = last;
    }

    public long getNext() {
        return next;
    }

    public void setNext(long next) {
        this.next = next;
    }

    public long getPages() {
        return pages;
    }

    public void setPages(long pages) {
        this.pages = pages;
    }

    public long getOffset() {
        return offset;
    }

    public void setOffset(long offset) {
        this.offset = offset;
    }

    public long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(long totalItems) {
        this.totalItems = totalItems;
    }

}
