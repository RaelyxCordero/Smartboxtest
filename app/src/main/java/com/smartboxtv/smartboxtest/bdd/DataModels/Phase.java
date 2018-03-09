
package com.smartboxtv.smartboxtest.bdd.DataModels;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Phase implements Serializable
{

    @SerializedName("original")
    @Expose
    private String original;
    private final static long serialVersionUID = 1777112478495742380L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Phase() {
    }

    /**
     * 
     * @param original
     */
    public Phase(String original) {
        super();
        this.original = original;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

}
