package com.maria.ass1.business.factory;

//import com.maria.ass1.model.produs.Produs;
import com.maria.ass1.model.user.User;

public class ChartPrelucrare {
    public User user;
    //List<Produs> produsList;
    public ChartPrelucrare(User user) {
        this.user = user;
    }

    public User generateProdus (User user, String type) {
        this.user=user;
        return user;

    }
}
