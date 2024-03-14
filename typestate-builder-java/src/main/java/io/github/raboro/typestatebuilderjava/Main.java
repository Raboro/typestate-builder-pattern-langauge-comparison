package io.github.raboro.typestatebuilderjava;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        final House house = new HouseBuilder()
                .setWalls(List.of(new House.Wall()))
                .setDoors(List.of(new House.Door()))
                .setGarage(new House.Garage())
                .setBasement(new House.Basement())
                .setWindows(List.of(new House.Window()))
                .build();
        System.out.println(house);
    }

    public static String hi() {
        return "hi";
    }
}
