package com.github.hofls.mapstruct.basic.car;

import com.github.hofls.mapstruct.basic.passenger.Passenger;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    private String make;
    private int numberOfSeats;
    private ECarType type;
    private List<Passenger> passengers;
    private Integer someWeirdField;

}
