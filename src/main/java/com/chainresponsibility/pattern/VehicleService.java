package com.chainresponsibility.pattern;

import com.chainresponsibility.model.VehicleOffer;
import com.chainresponsibility.nopattern.service.CarService;
import com.chainresponsibility.nopattern.service.MotoService;
import com.chainresponsibility.nopattern.service.Service;
import com.chainresponsibility.nopattern.service.TruckService;

import java.util.HashMap;
import java.util.Map;

public class VehicleService {

    private final Filter filterToSave;
    private final Filter filterToRemove;
    private final Map<String, Service> services = new HashMap<>();

    public VehicleService(CarService carService,
                          TruckService truckService,
                          MotoService motoService,
                          Filter filtersToSave,
                          Filter filtersToRemove) {
        services.put("car", carService);
        services.put("moto", motoService);
        services.put("truck", truckService);
        this.filterToSave = filtersToSave;
        this.filterToRemove = filtersToRemove;

    }

    public void analyze(VehicleOffer data) {
        if (filterToSave.filter(data)) {
                services.get(data.mark).save(data);
        }

        if (filterToRemove.filter(data)) {
            services.get(data.mark).save(data);
        }
    }
}
