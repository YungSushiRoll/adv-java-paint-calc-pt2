package edu.wctc;

import java.io.*;
import java.util.ArrayList;

public class RoomReader {
    public ArrayList<Paintable> readRoomFile(String fileName) throws IOException {

        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);

        ArrayList<Paintable> rooms = new ArrayList<>();

        Object obj;
        try {
            while ((obj = ois.readObject()) != null) {
                Paintable aRoom = (Paintable) obj;
                rooms.add(aRoom);
            }
        }catch (EOFException | ClassNotFoundException e) {
            // nothing
        }

        return rooms;
    }
}
