package com.cyber_chill.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "myapp.feature.discount")
public class DiscountProperties {
    private int firstTime;
    private int startRegular;
    private int middleRegular;
    private int vipRegular;


    public int getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(int firstTime) {
        this.firstTime = firstTime;
    }

    public int getStartRegular() {
        return startRegular;
    }

    public void setStartRegular(int startRegular) {
        this.startRegular = startRegular;
    }

    public int getMiddleRegular() {
        return middleRegular;
    }

    public void setMiddleRegular(int middleRegular) {
        this.middleRegular = middleRegular;
    }

    public int getVipRegular() {
        return vipRegular;
    }

    public void setVipRegular(int vipRegular) {
        this.vipRegular = vipRegular;
    }

}
