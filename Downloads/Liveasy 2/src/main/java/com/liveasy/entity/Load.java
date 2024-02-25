package com.liveasy.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name="load")
public class Load {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loadId;

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
