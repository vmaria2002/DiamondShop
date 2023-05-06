package com.maria.ass1.business.factory;

import com.maria.ass1.model.user.User;

public class EarringsProduct extends Chart{
    public EarringsProduct(User user) {
        super();
    }

    @Override
    public User generateChart(String type) {
        ChartPrelucrare chartPrelucrare=new ChartPrelucrare(this.user);
        User user1=chartPrelucrare.generateProdus(this.user, type);
        return user1;
    }
}
