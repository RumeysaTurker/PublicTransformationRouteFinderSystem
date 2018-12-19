package com.ege.publictransformationroutefindersystem;

public class Vehicles {
    private String vehicleID;
    private String vehicleRoute;
    private String vehicleType;
    private String routeEstimationTime;

    public Vehicles() {
    }

    public Vehicles(String vehicleID, String vehicleRoute, String vehicleType, String routeEstimationTime) {
        this.vehicleID = vehicleID;
        this.vehicleRoute = vehicleRoute;
        this.vehicleType = vehicleType;
        this.routeEstimationTime = routeEstimationTime;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getVehicleRoute() {
        return vehicleRoute;
    }

    public void setVehicleRoute(String vehicleRoute) {
        this.vehicleRoute = vehicleRoute;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getRouteEstimationTime() {
        return routeEstimationTime;
    }

    public void setRouteEstimationTime(String routeEstimationTime) {
        this.routeEstimationTime = routeEstimationTime;
    }
}
