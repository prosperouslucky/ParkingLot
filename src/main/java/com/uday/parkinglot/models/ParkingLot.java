package com.uday.parkinglot.models;

import com.uday.parkinglot.exceptions.ParkingLotException;
import com.uday.parkinglot.exceptions.ParkingLotFullException;
import com.uday.parkinglot.exceptions.VehicleNotParkedException;
import com.uday.parkinglot.strategy.AllotmentStrategy;
import com.uday.parkinglot.validators.ParkingValidator;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class ParkingLot {

    @Getter
    private int size;

    private List<Slot> slots;

    @Setter
    private AllotmentStrategy allotmentStrategy;

    private List<ParkingValidator> parkingValidators;

    public ParkingLot(int size, AllotmentStrategy allotmentStrategy, List<ParkingValidator> parkingValidators) {
        this.size = size;
        this.allotmentStrategy = allotmentStrategy;
        this.parkingValidators = parkingValidators;
        slots = new ArrayList<>();
        IntStream.range(1, size+1).forEach(i -> slots.add(new Slot(i)));
    }

    public Collection<Slot> getSlots() {
        return slots;
    }

    public void park(@NonNull Vehicle vehicle) throws ParkingLotException {
        for (ParkingValidator parkingValidator : parkingValidators) {
            parkingValidator.canPark(vehicle, this);
        }
        Optional<Slot> optionalSlot = allotmentStrategy.getSlot(this);
        if (optionalSlot.isPresent()) {
            optionalSlot.get().park(vehicle);
        } else {
            throw new ParkingLotFullException();
        }
    }

    public void leave(@NonNull Vehicle vehicle) throws ParkingLotException {
        Optional<Slot> optionalSlot = slots.stream().filter(s -> s.getVehicle() == vehicle).findAny();
        if (optionalSlot.isPresent()) {
            optionalSlot.get().leave();
        } else {
            throw new VehicleNotParkedException(vehicle);
        }
    }
}
