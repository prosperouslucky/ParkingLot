package com.uday.parkinglot.models;

import lombok.Getter;
import lombok.NonNull;

public class Slot {

    @Getter
    private final int index;

    @Getter
    private Vehicle vehicle;

    public Slot(int index) {
        this.index = index;
    }

    public boolean isFree() {
        return (vehicle == null);
    }

    public void park(@NonNull Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void leave() {
        this.vehicle = null;
    }
}
