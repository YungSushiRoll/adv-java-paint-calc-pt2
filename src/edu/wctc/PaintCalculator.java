package edu.wctc;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class PaintCalculator implements Serializable {

    private ArrayList<Paintable> paintList = new ArrayList<>();
    private Scanner keyboard;

    public static void main(String[] args) {
        new PaintCalculator();
    }

    public PaintCalculator() {
        keyboard = new Scanner(System.in);

        int option = 0;

        while (option != 5) {
            printMenu();

            String s = keyboard.nextLine();
            try {
                int choice = Integer.parseInt(s);
                switch (choice) {
                    case 1:
                        createRoom();
                        break;
                    case 2:
                        createDeck();
                        break;
                    case 3:
                        new RoomWriter().writeRoomFile("room.dat", paintList);
                        break;
                    case 4:
                        paintList = new RoomReader().readRoomFile("room.dat");
                        break;
                    case 5:
                        printRooms();
                        break;
                    case 6:
                        System.out.println("Goodbye");
                        System.exit(0);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void printRooms() {
        if (paintList.isEmpty()) {
            System.out.println("No rooms yet");
        }

        for (Paintable room : paintList) {
            System.out.println(room.toString());
        }
    }

    private void printMenu() {
        System.out.println();
        System.out.println("1. Add room");
        System.out.println("2. Add Deck");
        System.out.println("3. Write rooms to file");
        System.out.println("4. Read rooms from file");
        System.out.println("5. View rooms");
        System.out.println("6. Exit");
        System.out.println();
    }

    private int promptForDimension(String name) {
        System.out.print("Enter the room's " + name + ": ");
        String response = keyboard.nextLine();
        try {
            return Integer.parseInt(response);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private int promptForDeckDimension(String name) {
        System.out.print("Enter the deck's " + name + ": ");
        String response = keyboard.nextLine();
        try {
            return Integer.parseInt(response);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private void createRoom() {
        int length = promptForDimension("length");
        int width = promptForDimension("width");
        int height = promptForDimension("height");

        try {
            Room room = new Room(length, width, height);
            paintList.add(room);

            System.out.println("Room successfully created");
        } catch (BadWidthException | BadHeightException e) {
            System.out.println("Could not create room.");
        }

    }

    private void createDeck() {
        int length = promptForDeckDimension("length");
        int width = promptForDeckDimension("width");

        Deck deck = new Deck(length, width);
        paintList.add(deck);
    }
}
