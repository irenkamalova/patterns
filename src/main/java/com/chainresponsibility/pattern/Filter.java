package com.chainresponsibility.pattern;

import com.chainresponsibility.model.VehicleOffer;

public abstract class Filter {
    private Filter nextFilter;

    void setNextFilter(Filter nextFilter) {
        this.nextFilter = nextFilter;
    }
    boolean filter(VehicleOffer vehicleOffer) {
        if (nextFilter != null) {
            return nextFilter.filter(vehicleOffer);
        } else {
            return false;
        }
    }

}
