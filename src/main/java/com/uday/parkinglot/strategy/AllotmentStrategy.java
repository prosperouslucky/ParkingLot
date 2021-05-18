package com.uday.parkinglot.strategy;

import com.uday.parkinglot.models.ParkingLot;
import com.uday.parkinglot.models.Slot;

import java.util.Optional;

public interface AllotmentStrategy {
    Optional<Slot> getSlot(ParkingLot parkingLot);
}
