
package com.smartboxtv.smartboxtest.bdd.DataModels;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Name implements Serializable
{

    @SerializedName("es")
    @Expose
    private String es;
    @SerializedName("original")
    @Expose
    private String original;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Name() {
    }

    /**
     * 
     * @param original
     * @param es
     */
    public Name(String es, String original) {
        super();
        this.es = es;
        this.original = original;
    }

    public String getEs() {
        return es;
    }

    public void setEs(String es) {
        this.es = es;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    @Override
    public String toString() {
        return "Name{" +
                "es='" + es + '\'' +
                ", original='" + original + '\'' +
                '}';
    }
}
