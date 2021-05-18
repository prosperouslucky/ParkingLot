package com.uday.parkinglot.exceptions;

public class ParkingLotFullException extends ParkingLotException{
    private static final String message = "Parking Lot Full";
    public ParkingLotFullException() {
        super(message);
    }
}
