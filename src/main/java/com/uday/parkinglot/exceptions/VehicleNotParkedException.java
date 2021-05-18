package com.uday.parkinglot.exceptions;

import com.uday.parkinglot.models.Vehicle;
import lombok.NonNull;

public class VehicleNotParkedException extends ParkingLotException {

    private static final String message = "Vehicle with %s is not parked";

    public VehicleNotParkedException(@NonNull Vehicle vehicle) {
        super(String.format(message, vehicle.getId()));
    }
}
