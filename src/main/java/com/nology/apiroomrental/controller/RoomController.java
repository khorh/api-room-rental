package com.nology.apiroomrental.controller;

import com.nology.apiroomrental.entity.Message;
import com.nology.apiroomrental.entity.Room;
import com.nology.apiroomrental.respository.RoomRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {
    private final RoomRepository repository = new RoomRepository();

    // Create a new room
    @PostMapping("/rooms")
    public ResponseEntity<Message> createRoom(@RequestBody Room newRoom) {
        repository.addRoom(newRoom);
        Message successMessage = new Message("Successfully added new room");
        return ResponseEntity.status(HttpStatus.OK).body(successMessage);
    }

    // Read all existing rooms

    // Read a room based on its id

    // Update a room based on its id

    // Delete a room based on its id
}
