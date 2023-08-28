package com.esop.Esop_management.payload;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class VestingPlanDto {

    private int pid;
    private int vestingPeriod;
    private int cliffPeriod;

    private CompanyDto company;

}
