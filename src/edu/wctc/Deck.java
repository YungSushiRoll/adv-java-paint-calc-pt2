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
        return "Deck {" +
                "Deck ID = " + deckId +
                "\nArea=" + getArea() +
                '}';
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
