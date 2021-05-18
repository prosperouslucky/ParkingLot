package com.uday.parkinglot.strategy;

import com.uday.parkinglot.models.ParkingLot;
import com.uday.parkinglot.models.Slot;

import java.util.Collection;
import java.util.Optional;

public class DefaultAllotmentStrategy implements AllotmentStrategy {

    @Override
    public Optional<Slot> getSlot(ParkingLot parkingLot) {
        Collection<Slot> slots = parkingLot.getSlots();
        return slots.stream().filter(Slot::isFree).findAny();
    }
}
