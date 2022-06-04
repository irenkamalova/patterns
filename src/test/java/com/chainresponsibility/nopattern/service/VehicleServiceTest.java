package com.chainresponsibility.nopattern.service;

import com.chainresponsibility.model.VehicleOffer;
import com.chainresponsibility.nopattern.service.service1.VehicleService;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

class VehicleServiceTest {

    CarService carService = mock(CarService.class);
    TruckService truckService = mock(TruckService.class);
    MotoService motoService = mock(MotoService.class);
    VehicleService vehicleService = new VehicleService(carService, truckService, motoService);

    @Test
    public void should_save_BMW_cars() {
        var data = new VehicleOffer("1", "car", "BMW", "blue", Instant.now());
        vehicleService.analyze(data);
        verify(carService).save(data);
    }

    @Test
    public void should_not_save_not_BMW_cars() {
        vehicleService.analyze(new VehicleOffer("1", "car", "any", "blue", Instant.now()));
        verifyZeroInteractions(carService);
    }

}