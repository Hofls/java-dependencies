package com.github.hofls.designpatterns.structural.flyweight;

/**
 * Flyweight shares common parts of state between multiple objects instead of keeping all the data in each object
 */
public class Main {

    public void example() {
        Classes.Car busA = new Classes.Car(Classes.BusSprite.getInstance());
        Classes.Car busB = new Classes.Car(Classes.BusSprite.getInstance());
        Classes.Car sportCar = new Classes.Car(Classes.SportCarSprite.getInstance());
    }

}
