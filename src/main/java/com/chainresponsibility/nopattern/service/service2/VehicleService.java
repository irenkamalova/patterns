package com.chainresponsibility.nopattern.service.service2;

import com.chainresponsibility.model.VehicleOffer;
import com.chainresponsibility.nopattern.service.CarService;
import com.chainresponsibility.nopattern.service.MotoService;
import com.chainresponsibility.nopattern.service.TruckService;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class VehicleService {

    private final CarService carService;
    private final TruckService truckService;
    private final MotoService motoService;

    public VehicleService(CarService carService, TruckService truckService, MotoService motoService) {
        this.carService = carService;
        this.truckService = truckService;
        this.motoService = motoService;
    }

    public void analyze(VehicleOffer data) {
        if (data.type == "car" && data.mark == "BMW") {
            carService.save(data);
        }

        if (data.type == "car" && data.creationDate.isBefore(Instant.now().minus(10, ChronoUnit.YEARS))) {
            carService.remove(data);
        }

        if (data.type == "truck" && data.mark == "BMW") {
            truckService.save(data);
        }

        if (data.type == "truck" && data.creationDate.isBefore(Instant.now().minus(10, ChronoUnit.YEARS))) {
            truckService.remove(data);
        }

        if (data.type == "moto" && data.creationDate.isBefore(Instant.now().minus(10, ChronoUnit.YEARS))) {
            truckService.remove(data);
        }
        if (data.type == "moto" && data.colour == "black") {
            motoService.remove(data);
        }
    }
}
