package com.maria.ass1.business.factory;

import com.maria.ass1.model.user.User;

public class ChartCreator {
    public enum chartfactory {
        BRACELET,
        CHARM,
        EARRINGS,
        NECKLACE,
        RING;
    }



    public static Chart createChart(chartfactory type, User user) {
        switch(type) {
            case BRACELET:
                return new BraceletProduct(user);
            case CHARM:
                return new CharmProduct(user);
            case EARRINGS:
                return new EarringsProduct(user);
            case NECKLACE:
                return new NecklageProduct(user);
            case RING:
                return new RingProduct(user);
            default:
                throw new IllegalArgumentException("Invalid report type: " + type);
        }
    }
}