package edu.wctc;

import java.io.Serializable;
import java.util.ArrayList;

public class Room implements Paintable, Serializable {

    private static int roomCount = 0;

    private int roomNum;

    private ArrayList<Wall> wallList;

    public Room(double length, double width, double height) throws BadWidthException, BadHeightException {
        roomCount++;
        roomNum = roomCount;
        wallList = new ArrayList<Wall>();

        Wall wallA = new Wall(length, height);
        wallList.add(wallA);
        Wall wallB = new Wall(length, height);
        wallList.add(wallB);
        Wall wallC = new Wall(width, height);
        wallList.add(wallC);
        Wall wallD = new Wall(width, height);
        wallList.add(wallD);
    }

    public double getArea() {
        double area = 0;

        for (int i = 0; i < wallList.size(); i++) {
            Wall w = wallList.get(i);
            area += w.getArea();
        }

        return area;
    }

    @Override
    public String toString() {
        return "---- Room ----" +
                "\nRoom Number: " + roomNum +
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
