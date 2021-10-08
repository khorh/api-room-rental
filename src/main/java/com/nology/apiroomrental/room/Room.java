package com.nology.apiroomrental.room;

public class Room {
    // Properties
    private int id;
    private String roomName;
    private String roomDescription;
    private String[] roomFacilities;
    private int pricePerNight;

    // Constructor
    public Room(int id, String roomName, String roomDescription, String[] roomFacilities, int pricePerNight) {
        this.id = id;
        this.roomName = roomName;
        this.roomDescription = roomDescription;
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

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
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
