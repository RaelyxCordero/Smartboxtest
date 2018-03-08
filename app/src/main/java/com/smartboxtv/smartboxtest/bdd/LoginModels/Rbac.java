package com.smartboxtv.smartboxtest.bdd.LoginModels;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rbac implements Serializable
{

    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("template")
    @Expose
    private String template;

    public Rbac(String role, String template) {
        this.role = role;
        this.template = template;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

}