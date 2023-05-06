package com.maria.ass1.business.factory;

import com.maria.ass1.model.user.User;

public class CharmProduct extends Chart{
    public CharmProduct(User user) {
        super();
    }

    @Override
    public User generateChart(String type) {
        ChartPrelucrare chartPrelucrare=new ChartPrelucrare(this.user);
        User user1=chartPrelucrare.generateProdus(this.user, type);
        return user1;
    }
}
