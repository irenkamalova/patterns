package com.chainresponsibility.pattern;

import com.chainresponsibility.model.VehicleOffer;


public class CarBMWFilter extends Filter {
    public static CarBMWFilter carBMWFilter = carBMWFilter();
    public static CarBMWFilter truckBMWFilter = carBMWFilter();
    public static CarBMWFilter motoBlackFilter = carBMWFilter();


    public static CarBMWFilter carOutdatedFilter = carBMWFilter();
    public static CarBMWFilter truckOutdatedFilter = carBMWFilter();
    public static CarBMWFilter motoOutdatedFilter = carBMWFilter();

    private CarBMWFilter() {}

    public static CarBMWFilter carBMWFilter() {
        return new CarBMWFilter();
    }

    public boolean filter(VehicleOffer data) {
         return (data.type == "car" && data.mark == "BMW")
             || super.filter(data);
    }


}
