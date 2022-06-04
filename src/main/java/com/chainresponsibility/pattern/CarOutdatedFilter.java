package com.chainresponsibility.pattern;

import com.chainresponsibility.model.VehicleOffer;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class CarOutdatedFilter extends Filter {
    public boolean filter(VehicleOffer data) {
        return data.type == "car" && data.creationDate.isBefore(Instant.now().minus(10, ChronoUnit.YEARS)) || super.filter(data);
    }
}
