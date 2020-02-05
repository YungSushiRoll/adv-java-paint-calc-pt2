package edu.wctc;

import java.io.*;
import java.util.ArrayList;

public class RoomWriter {
    public void writeRoomFile(String fileName, ArrayList<Paintable> roomList) throws IOException {

        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        for (Paintable aRoom : roomList) {
            oos.writeObject(aRoom);
        }

        oos.close();
    }
}
