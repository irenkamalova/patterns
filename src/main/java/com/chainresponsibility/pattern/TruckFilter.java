package com.chainresponsibility.pattern;

import com.chainresponsibility.model.VehicleOffer;

public class TruckFilter extends Filter {

    @Override
    public boolean filter(VehicleOffer vehicleOffer) {
        return false;
    }
}
