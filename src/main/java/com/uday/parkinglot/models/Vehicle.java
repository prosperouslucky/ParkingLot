package com.uday.parkinglot.models;

import lombok.Getter;
import lombok.NonNull;

public class Vehicle {

    @Getter
    private final String id;

    public Vehicle(@NonNull String id) {
        this.id = id;
    }
}
