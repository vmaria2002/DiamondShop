package com.maria.ass1.raport;

import com.maria.ass1.model.user.User;

public abstract class Report {
    public User user;
    public String nameFile;

    public Report(User user, String nameFile){
        this.user=user;
        this.nameFile=nameFile;
    }
    public abstract void generateReport();
}
