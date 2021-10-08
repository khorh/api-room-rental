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
    private final Room newRoom = new Room(4, "Family room", new String[]{"multiple sinks", "bunk beds"}, 150);

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
                .andExpect(jsonPath("$.message", is("Successfully added new room")))
                .andReturn();

        mockMvc.perform(delete("/recipes/4"));
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

    private static String toJson(Room newRoom) throws JsonProcessingException {
        System.out.println(new ObjectMapper().writeValueAsString(newRoom));
        return new ObjectMapper().writeValueAsString(newRoom);
    }
}
