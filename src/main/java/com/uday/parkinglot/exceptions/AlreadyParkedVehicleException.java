package com.uday.parkinglot.exceptions;

import com.uday.parkinglot.models.Slot;
import com.uday.parkinglot.models.Vehicle;

public class AlreadyParkedVehicleException extends ParkingLotException {

    private static final String message = "Vehicle with %s is already parked at %d slot";

    public AlreadyParkedVehicleException(Vehicle vehicle, Slot slot) {
        super(String.format(message, vehicle.getId(), slot.getIndex()));
    }
}
