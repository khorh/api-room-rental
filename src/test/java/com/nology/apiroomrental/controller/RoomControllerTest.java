package com.nology.apiroomrental.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nology.apiroomrental.entity.Room;
import com.nology.apiroomrental.respository.RoomRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RoomController.class)
public class RoomControllerTest {
    private final Room newRoom = new Room(4, "family room", new String[]{"multiple sinks", "bunk beds"}, 150);
    private final Room changeRoom = new Room(2, "posh room", new String[] {"espresso machine", "dyson hairdryer"}, 200);

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RoomRepository repo;

    @Test
    @DisplayName("Create route should create a new room and return a success message")
    public void createRouteShouldCreateANewRoomAndReturnASuccessMessage() throws Exception {
        mockMvc.perform(post("/rooms")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(newRoom))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.text", is("Successfully added new room")))
                .andReturn();

        mockMvc.perform(delete("/rooms/4"));
    }

    @Test
    @DisplayName("Read route should return all rooms")
    public void readRouteShouldReturnAllRooms() throws Exception {
        mockMvc.perform(get("/rooms"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].roomName", is("penthouse")))
                .andReturn();
    }

    @Test
    @DisplayName("Read route should return a room based on id")
    public void readRouteShouldReturnARoomBasedOnId() throws Exception {
        mockMvc.perform(get("/rooms/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.roomName", is("penthouse")))
                .andExpect(jsonPath("$.roomFacilities", hasSize(1)))
                .andExpect(jsonPath("$.pricePerNight", is(300)))
                .andReturn();
    }

    @Test
    @DisplayName("Updated route should change the room based on id and return a success message")
    public void updatedRouteShouldChangeTheRoomBasedOnIdAndReturnASuccessMessage() throws Exception {
        mockMvc.perform(put("/rooms/2")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(changeRoom))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.text", is("Successfully updated a room")))
                .andReturn();
    }
    // Change to message

    @Test
    @DisplayName("Delete route should delete the room based on id and return a success message")
    public void deleteRouteShouldDeleteTheRoomBasedOnIdAndReturnASuccessMessage() throws Exception {
        mockMvc.perform(delete("/rooms/3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.text", is("Successfully deleted a room")))
                .andReturn();

    }

    private static String toJson(Room newRoom) throws JsonProcessingException {
        System.out.println(new ObjectMapper().writeValueAsString(newRoom));
        return new ObjectMapper().writeValueAsString(newRoom);
    }
}
