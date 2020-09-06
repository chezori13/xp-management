package com.platform.cloud.xpmanagement.view;


import javax.validation.constraints.NotNull;

public class ExperienceLog {

    @NotNull
    private Integer points;

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}
