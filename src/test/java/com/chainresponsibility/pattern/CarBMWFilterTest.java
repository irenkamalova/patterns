package com.chainresponsibility.pattern;

import com.chainresponsibility.model.VehicleOffer;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static com.chainresponsibility.pattern.CarBMWFilter.carBMWFilter;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarBMWFilterTest {

    @Test
    public void should_filter_car_BMW() {
        assertTrue(carBMWFilter.filter(new VehicleOffer("id", "car", "BWM", "blue", Instant.now())));
    }

}