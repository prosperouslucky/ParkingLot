package com.uday.parkinglot.validators;

import com.uday.parkinglot.exceptions.AlreadyParkedVehicleException;
import com.uday.parkinglot.models.ParkingLot;
import com.uday.parkinglot.models.Slot;
import com.uday.parkinglot.models.Vehicle;
import lombok.NonNull;

import java.util.Collection;
import java.util.Optional;

public class ExistingVehicleValidator implements ParkingValidator {

    @Override
    public void canPark(@NonNull Vehicle vehicle, @NonNull ParkingLot parkingLot) throws AlreadyParkedVehicleException {
        Collection<Slot> slots = parkingLot.getSlots();
        Optional<Slot> optionalSlot = slots.stream().filter(s -> s.getVehicle() == vehicle).findAny();
        if (optionalSlot.isPresent()) {
            throw new AlreadyParkedVehicleException(vehicle, optionalSlot.get());
        }
    }
}
