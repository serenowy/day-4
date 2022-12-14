package com.example.day4.model;

import jakarta.validation.constraints.*;
import jdk.jfr.BooleanFlag;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

@Data
@AllArgsConstructor
public class emp {

    @Size(min = 2 ,max=10,  message =" cannot be null Length more than 2" )
    private String ID ;
    @Size(min = 4, max=10, message =" cannot be null Length more than 4" )

    private String name;
    @NotNull(message= "  not be null")
    @Size( min =25,max = 50, message =" should be more than 25 " )
    private int age ;
@AssertFalse(message = "it is must be false")
    private Boolean onLeave;


    @NotNull (message= "  not be null")
    @Range (min = 1960,max = 2022,message ="it must vaild year" )
    private  int employmentYear;
    @NotNull (message= "  not be null it has to be number")
    private String annualLeave  ;
}
