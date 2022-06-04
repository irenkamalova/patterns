package com.chainresponsibility.model;

import java.time.Instant;

public class VehicleOffer {
    public final String id;
    public final String type;
    public final String mark;
    public final String colour;
    public final Instant creationDate;

    public VehicleOffer(String id, String type, String mark, String colour, Instant creationDate) {
        this.id = id;
        this.type = type;
        this.mark = mark;
        this.colour = colour;
        this.creationDate = creationDate;
    }
}
