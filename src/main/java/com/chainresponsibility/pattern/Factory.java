package com.chainresponsibility.pattern;

import com.chainresponsibility.nopattern.service.CarService;
import com.chainresponsibility.nopattern.service.MotoService;
import com.chainresponsibility.nopattern.service.TruckService;

import static com.chainresponsibility.pattern.CarBMWFilter.carBMWFilter;
import static com.chainresponsibility.pattern.CarBMWFilter.carOutdatedFilter;
import static com.chainresponsibility.pattern.CarBMWFilter.motoBlackFilter;
import static com.chainresponsibility.pattern.CarBMWFilter.motoOutdatedFilter;
import static com.chainresponsibility.pattern.CarBMWFilter.truckBMWFilter;
import static com.chainresponsibility.pattern.CarBMWFilter.truckOutdatedFilter;

public class Factory {

    public VehicleService vehicleService() {

       Filter filterToSave = carBMWFilter;
        carBMWFilter.setNextFilter(truckBMWFilter);
        truckBMWFilter.setNextFilter(motoBlackFilter);

       Filter filterToDelete = carOutdatedFilter;
        carOutdatedFilter.setNextFilter(truckOutdatedFilter);
        truckOutdatedFilter.setNextFilter(motoOutdatedFilter);

        return new VehicleService(
            new CarService(),
            new TruckService(),
            new MotoService(),
            filterToSave,
            filterToDelete
        );
    }

}
