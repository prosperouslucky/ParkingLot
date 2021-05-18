package com.uday.parkinglot.validators;

import com.uday.parkinglot.exceptions.ParkingLotException;
import com.uday.parkinglot.models.ParkingLot;
import com.uday.parkinglot.models.Vehicle;

public interface ParkingValidator {
    void canPark(Vehicle vehicle, ParkingLot parkingLot) throws ParkingLotException;
}
