package com.chainresponsibility.pattern;

import org.junit.jupiter.api.Test;

class VehicleServiceTest {

    VehicleService vehicleService = new VehicleService(null, null, null, null, null);

    @Test
    public void test() {
        vehicleService.analyze(null);
        Factory f = new Factory();
        VehicleService v = f.vehicleService();
    }

}