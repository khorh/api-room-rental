package com.nology.apiroomrental.controller;

import com.nology.apiroomrental.entity.Message;
import com.nology.apiroomrental.entity.Room;
import com.nology.apiroomrental.respository.RoomRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {
    private final RoomRepository repository = new RoomRepository();

    // Create a new room
    @PostMapping("/rooms")
    public ResponseEntity<Message> createRoom(@RequestBody Room newRoom) {
        repository.addRoom(newRoom);
        Message successMessage = new Message("Successfully added new room");
        return ResponseEntity.status(HttpStatus.CREATED).body(successMessage);
    }

    // Read all existing rooms
    @GetMapping("/rooms")
    public ResponseEntity<List<Room>> getAllRooms() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAllRooms());
    }

    // Read a room based on its id
    @GetMapping("/rooms/{id}")
    public ResponseEntity<Room> getARoom(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findRoomById(id));
    }

    // Update a room based on its id

    // Delete a room based on its id
}
