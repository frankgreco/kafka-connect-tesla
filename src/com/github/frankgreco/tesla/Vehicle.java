package com.github.frankgreco.tesla;

public class Vehicle {

    private String id;
    private String vehicleId;
    private String vin;
    private String displayName;
    private String[] optionCodes;
    private String color;
    private String[] tokens;
    private String state;
    private String inService;
    private boolean calendarEnabled;
    private String backseatToken;
    private String backseatTokenUpdateAt;

    public String getId() {
        return id;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getVin() {
        return vin;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String[] getOptionCodes() {
        return optionCodes;
    }

    public String getColor() {
        return color;
    }

    public String[] getTokens() {
        return tokens;
    }

    public String getState() {
        return state;
    }

    public String getInService() {
        return inService;
    }

    public boolean isCalendarEnabled() {
        return calendarEnabled;
    }

    public String getBackseatToken() {
        return backseatToken;
    }

    public String getBackseatTokenUpdateAt() {
        return backseatTokenUpdateAt;
    }

}
