package com.chainresponsibility.pattern;

import com.chainresponsibility.model.VehicleOffer;

public class MotoFilter extends Filter {

    public boolean filter(VehicleOffer data) {
        return data.type == "car" && data.mark == "BMW";
    }
}
