
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
    private final static long serialVersionUID = 417654171144191591L;

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

}
