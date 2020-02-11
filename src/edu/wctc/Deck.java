package edu.wctc;

import java.io.Serializable;

public class Deck implements Paintable, Serializable {

    private static int deckCount = 0;
    private int deckId;
    private double width;
    private double length;

    public Deck(double length, double width) throws BadLengthException, BadWidthException {

        this.length = length;

        if (length <= 0)
            throw new BadLengthException("Length must be greater than zero!");

        this.width = width;

        if (width <= 0)
            throw new BadWidthException("Width must be greater than zero!");

        deckCount++;
        deckId = deckCount;
    }

    public double getArea() {

        double area = length * width;

        return area;
    }

    @Override
    public String toString() {
        return "---- Deck ----" +
                "\nDeck ID: " + deckId +
                "\nArea: " + getArea() +
                "\nPremium Paint Cost: " + getPremiumCost() +
                "\nStandard Paint Cost: " + getStandardCost();
    }

    @Override
    public double getPremiumCost() {
        return Math.ceil(getArea()/400) * PREMIUM_PAINT_COST_PER_GALLON;
    }

    @Override
    public double getStandardCost() {
        return Math.ceil(getArea()/400) * STANDARD_PAINT_COST_PER_GALLON;
    }
}
