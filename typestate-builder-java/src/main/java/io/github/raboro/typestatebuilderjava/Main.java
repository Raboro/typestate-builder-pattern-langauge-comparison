package io.github.raboro.typestatebuilderjava;

import io.github.raboro.typestatebuilderjava.typestate.HouseTypeStateBuilder;

import java.util.ArrayList;
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

        final House house1 = new HouseTypeStateBuilder()
                .setGarage(new House.Garage())
                .setWindows(new ArrayList<>())
                .setDoors(List.of(new House.Door()))
                .setBasement(new House.Basement())
                .setWalls(List.of(new House.Wall()))
                .setBasement(new House.Basement())
                .setDoors(new ArrayList<>())
                .build();
        System.out.println(house1);
    }

    public static String hi() {
        return "hi";
    }
}
