package com.maria.ass1.model.products;

public enum Type {
    BRACELET,
    CHARM,
    EARRINGS,
    NECKLACE,
    RING;
    public static Type parseType(String s) {
        if (s.equals("bracelet")) {
            return Type.BRACELET;
        }
        if (s.equals("charm")) {
            return Type.CHARM;
        }
        if (s.equals("earrings")) {
            return Type.EARRINGS;
        }
        if (s.equals("necklace")) {
            return Type.NECKLACE;
        }
        if (s.equals("ring")) {
            return Type.RING;
        }
        return null;
    }
}
