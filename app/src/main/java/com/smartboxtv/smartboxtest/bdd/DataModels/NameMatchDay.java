
package com.smartboxtv.smartboxtest.bdd.DataModels;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NameMatchDay implements Serializable
{

    @SerializedName("original")
    @Expose
    private String original;

    /**
     * No args constructor for use in serialization
     * 
     */
    public NameMatchDay() {
    }

    /**
     * 
     * @param original
     */
    public NameMatchDay(String original) {
        super();
        this.original = original;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    @Override
    public String toString() {
        return "NameMatchDay{" +
                "original='" + original + '\'' +
                '}';
    }
}
