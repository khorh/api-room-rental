package com.nology.apiroomrental.respository;

import com.nology.apiroomrental.entity.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomRepository {
    private List<Room> roomDatabase = new ArrayList<>();

    public void addRoom(Room newRoom) {
        roomDatabase.add(newRoom);
    }

    public List<Room> findAllRooms() {
        return roomDatabase;
    }
}
