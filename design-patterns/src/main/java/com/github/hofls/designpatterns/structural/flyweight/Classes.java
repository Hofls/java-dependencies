package com.github.hofls.designpatterns.structural.flyweight;

public class Classes {

    /** Sprite consumes a lot of RAM */
    interface Sprite {}

    public static class SportCarSprite implements Sprite {
        private static SportCarSprite sprite;
        private SportCarSprite() {}
        public static SportCarSprite getInstance() {
            if (sprite == null) {
                sprite = new SportCarSprite();
            }
            return sprite;
        }
    }

    public static class BusSprite implements Sprite {
        private static BusSprite sprite;
        private BusSprite() {}
        public static BusSprite getInstance() {
            if (sprite == null) {
                sprite = new BusSprite();
            }
            return sprite;
        }
    }


    public static class Car {
        private Sprite sprite;
        private int coordinateX;
        private int coordinateY;
        private int speed;
        private int direction;

        public Car(Sprite sprite) {
            this.sprite = sprite;
        }
    }

}
