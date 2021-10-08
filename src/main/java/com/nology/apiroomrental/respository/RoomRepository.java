package com.nology.apiroomrental.respository;

import com.nology.apiroomrental.entity.Room;
import com.nology.apiroomrental.exceptions.ResourceNotFoundException;

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

    public Room findRoomById(int id) throws ResourceNotFoundException {
        Room foundRoom = roomDatabase.stream()
                .filter((room) -> room.getId() == id)
                .findFirst()
                .orElse(null);
        if (foundRoom == null) throw new ResourceNotFoundException("Invalid id " + id + ", please try again.");
        return foundRoom;
    }

    public Room changeRoomById(int id, Room newRoom) throws ResourceNotFoundException {
        Room existingRoom = findRoomById(id);
        int index = roomDatabase.indexOf(existingRoom);
        roomDatabase.set(index, newRoom);
        return existingRoom;
    }

    public void deleteRoomById(int id) throws ResourceNotFoundException {
        roomDatabase.remove(findRoomById(id));
    }
}
