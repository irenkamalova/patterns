package com.chainresponsibility.nopattern.service;

import com.chainresponsibility.model.VehicleOffer;

public interface Service {
    
    void save(VehicleOffer offer);

    void remove(VehicleOffer data);
}
