package com.nology.apiroomrental.entity;

public class Room {
    // Properties
    private int id;
    private String roomName;
    private String[] roomFacilities;
    private int pricePerNight;

    // Constructor
    public Room(int id, String roomName, String[] roomFacilities, int pricePerNight) {
        this.id = id;
        this.roomName = roomName;
        this.roomFacilities = roomFacilities;
        this.pricePerNight = pricePerNight;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String[] getRoomFacilities() {
        return roomFacilities;
    }

    public void setRoomFacilities(String[] roomFacilities) {
        this.roomFacilities = roomFacilities;
    }

    public int getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(int pricePerNight) {
        this.pricePerNight = pricePerNight;
    }
}
