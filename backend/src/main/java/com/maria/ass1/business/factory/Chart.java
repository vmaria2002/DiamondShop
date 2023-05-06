package com.maria.ass1.business.factory;
import com.maria.ass1.model.user.User;

public abstract class Chart {
    public User user;
    public String type;

    public Chart(){
        this.user=user;

    }
    public abstract User generateChart(String type);

    public void dumpReport(Chart chart) {
    }
}
