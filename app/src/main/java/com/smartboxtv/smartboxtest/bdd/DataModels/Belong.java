
package com.smartboxtv.smartboxtest.bdd.DataModels;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Belong implements Serializable
{

    @SerializedName("Client")
    @Expose
    private String client;
    @SerializedName("AccessGroup")
    @Expose
    private List<String> accessGroup = null;
    @SerializedName("Tournament")
    @Expose
    private List<String> tournament = null;
    private final static long serialVersionUID = 9115548873330498779L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Belong() {
    }

    /**
     * 
     * @param tournament
     * @param client
     * @param accessGroup
     */
    public Belong(String client, List<String> accessGroup, List<String> tournament) {
        super();
        this.client = client;
        this.accessGroup = accessGroup;
        this.tournament = tournament;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public List<String> getAccessGroup() {
        return accessGroup;
    }

    public void setAccessGroup(List<String> accessGroup) {
        this.accessGroup = accessGroup;
    }

    public List<String> getTournament() {
        return tournament;
    }

    public void setTournament(List<String> tournament) {
        this.tournament = tournament;
    }

}
