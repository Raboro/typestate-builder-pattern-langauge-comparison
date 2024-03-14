package io.github.raboro.typestatebuilderjava;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HouseBuilder {
    private Optional<List<House.Wall>> walls;
    private Optional<List<House.Door>> doors;
    private Optional<House.Garage> garage;
    private Optional<House.Basement> basement;
    private Optional<List<House.Window>> windows;

    public HouseBuilder() {
        this.walls = Optional.empty();
        this.doors = Optional.empty();
        this.garage = Optional.empty();
        this.basement = Optional.empty();
        this.windows = Optional.empty();
    }

    public HouseBuilder setWalls(List<House.Wall> walls) {
        this.walls = Optional.of(walls);
        return this;
    }

    public HouseBuilder setDoors(List<House.Door> doors) {
        this.doors = Optional.of(doors);
        return this;
    }

    public HouseBuilder setGarage(House.Garage garage) {
        this.garage = Optional.of(garage);
        return this;
    }

    public HouseBuilder setBasement(House.Basement basement) {
        this.basement = Optional.of(basement);
        return this;
    }

    public HouseBuilder setWindows(List<House.Window> windows) {
        this.windows = Optional.of(windows);
        return this;
    }

    public House build() {
        return new House(
                this.walls.orElseGet(ArrayList::new),
                this.doors.orElseGet(ArrayList::new),
                this.garage,
                this.basement,
                this.windows
        );
    }
}
