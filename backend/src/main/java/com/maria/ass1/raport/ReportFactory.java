package com.maria.ass1.raport;

import com.maria.ass1.model.user.User;

public class ReportFactory {
    public enum ReportType {
        TXT,
        JSON
    }

    public static Report createReport(ReportType type, User user, String nume) {
        switch(type) {
            case TXT:
                return new TxtReport(user, nume);
            case JSON:
                return new JsonReport(user, nume);
            default:
                throw new IllegalArgumentException("Invalid report type: " + type);
        }
    }
}