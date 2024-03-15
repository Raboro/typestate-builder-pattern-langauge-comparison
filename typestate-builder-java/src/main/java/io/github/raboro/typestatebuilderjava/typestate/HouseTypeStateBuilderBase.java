package io.github.raboro.typestatebuilderjava.typestate;

import io.github.raboro.typestatebuilderjava.House;

import java.util.List;

interface HouseTypeStateBuilderBase<T> {

    T setGarage(House.Garage garage);

    T setBasement(House.Basement basement);

    T setWindows(List<House.Window> windows);
}
