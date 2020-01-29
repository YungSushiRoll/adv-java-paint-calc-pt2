package edu.wctc;

import java.io.*;
import java.util.ArrayList;

public class RoomReader {
    public ArrayList<Room> readRoomFile(String fileName) throws IOException {

        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);

        ArrayList<Room> rooms = new ArrayList<>();

        Object obj;
        try {
            while ((obj = ois.readObject()) != null) {
                Room aRoom = (Room) obj;
                rooms.add(aRoom);
            }
        }catch (EOFException | ClassNotFoundException e) {
            // nothing
        }

        return rooms;
    }
}
