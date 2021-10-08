package com.nology.apiroomrental.respository;

import com.nology.apiroomrental.entity.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomRepository {
    private List<Room> roomDatabase = new ArrayList(List.of(
            new Room(1, "penthouse", new String[] {"butler"}, 300),
            new Room(2, "luxury room", new String[] {"espresso machine", "dyson hairdryer"}, 200),
            new Room(3, "standard room", new String[] {"kettle", "hairdryer"}, 100)
    ));

    public void addRoom(Room newRoom) {
        roomDatabase.add(newRoom);
    }

    public List<Room> findAllRooms() {
        return roomDatabase;
    }

    public Room findRoomById(int id) {
        Room foundRoom = roomDatabase.stream()
                .filter((room) -> room.getId() == id)
                .findFirst()
                .orElse(null);
        return foundRoom;
    }

    public Room changeRoomById(int id, Room newRoom) {
        Room existingRoom = findRoomById(id);
        int index = roomDatabase.indexOf(existingRoom);
        roomDatabase.set(index, newRoom);
        return existingRoom;
    }

    public void deleteRoomById(int id) {
        roomDatabase.remove(findRoomById(id));
    }
}
