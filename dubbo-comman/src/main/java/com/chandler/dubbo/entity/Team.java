package com.chandler.dubbo.entity;

import java.io.Serializable;

public class Team implements Serializable {
    private String name;
    private String city;
    private String topPlayer;

    public Team(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTopPlayer() {
        return topPlayer;
    }

    public void setTopPlayer(String topPlayer) {
        this.topPlayer = topPlayer;
    }
}
