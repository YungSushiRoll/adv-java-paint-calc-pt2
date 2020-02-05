package edu.wctc;

import java.io.Serializable;

public class Deck implements Paintable, Serializable {

    private static int deckCount = 0;
    private int deckId;


    public Deck(int length, int width) {
        deckCount++;
        deckId = deckCount;
    }

    @Override
    public double getPremiumCost() {
        return 0;
    }

    @Override
    public double getStandardCost() {
        return 0;
    }
}
