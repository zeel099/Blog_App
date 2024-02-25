package com.liveasy.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class LoadDto {

    private String loadingPoint;
    private String unloadingPoint;
    private String productType;

    private String truckType;

    private int noOfTrucks;

    private int weight;

    private String comment;

    private UUID shipperId;

    private Date date;
}
