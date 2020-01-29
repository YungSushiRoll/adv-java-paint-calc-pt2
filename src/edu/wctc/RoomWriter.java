package edu.wctc;

import java.io.*;
import java.util.ArrayList;

public class RoomWriter {
    public void writeRoomFile(String fileName, ArrayList<Room> roomList) throws IOException {

        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        for (Room aRoom : roomList) {
            oos.writeObject(aRoom);
        }

        oos.close();
    }
}
