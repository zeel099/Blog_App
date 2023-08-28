package com.esop.Esop_management.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="vesting_plan")
@Getter
@Setter
@NoArgsConstructor
public class VestingPlan {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;
    private int vestingPeriod;
    private int cliffPeriod;

    @ManyToOne
    private Company company;

    @ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private Emp emp;


}
