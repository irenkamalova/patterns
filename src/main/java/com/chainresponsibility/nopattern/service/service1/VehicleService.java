package com.chainresponsibility.nopattern.service.service1;

import com.chainresponsibility.model.VehicleOffer;
import com.chainresponsibility.nopattern.service.CarService;
import com.chainresponsibility.nopattern.service.MotoService;
import com.chainresponsibility.nopattern.service.TruckService;

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

        if (data.type == "truck" && data.mark == "BMW") {
            truckService.save(data);
        }

        if (data.type == "moto" && data.colour == "black") {
            motoService.save(data);
        }
    }
}
