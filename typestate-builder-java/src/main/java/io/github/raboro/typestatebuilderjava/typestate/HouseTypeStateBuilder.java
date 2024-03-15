package io.github.raboro.typestatebuilderjava.typestate;

import io.github.raboro.typestatebuilderjava.House;

import java.util.List;
import java.util.Optional;

public class HouseTypeStateBuilder implements HouseTypeStateBuilderBase<HouseTypeStateBuilder> {
    private Optional<House.Garage> garage;
    private Optional<House.Basement> basement;
    private Optional<List<House.Window>> windows;

    public HouseTypeStateBuilderWalls setWalls(List<House.Wall> walls) {
        return new HouseTypeStateBuilderWalls(
                walls,
                this.garage,
                this.basement,
                this.windows
        );
    }

    public HouseTypeStateBuilderDoors setDoors(List<House.Door> doors) {
        return new HouseTypeStateBuilderDoors(
                doors,
                this.garage,
                this.basement,
                this.windows
        );
    }

    @Override
    public HouseTypeStateBuilder setGarage(House.Garage garage) {
        this.garage = Optional.of(garage);
        return this;
    }

    @Override
    public HouseTypeStateBuilder setBasement(House.Basement basement) {
        this.basement = Optional.of(basement);
        return this;
    }

    @Override
    public HouseTypeStateBuilder setWindows(List<House.Window> windows) {
        this.windows = Optional.of(windows);
        return this;
    }

    public class HouseTypeStateBuilderWalls implements HouseTypeStateBuilderBase<HouseTypeStateBuilderWalls> {
        private final List<House.Wall> walls;
        private Optional<House.Garage> garage;
        private Optional<House.Basement> basement;
        private Optional<List<House.Window>> windows;

        protected HouseTypeStateBuilderWalls(List<House.Wall> walls,
                                             Optional<House.Garage> garage,
                                             Optional<House.Basement> basement,
                                             Optional<List<House.Window>> windows) {
            this.walls = walls;
            this.garage = garage;
            this.basement = basement;
            this.windows = windows;
        }

        public HouseTypeStateBuilderBuildable setDoors(List<House.Door> doors) {
            return new HouseTypeStateBuilderBuildable(
                    walls, doors, this.garage, this.basement, this.windows
            );
        }

        @Override
        public HouseTypeStateBuilderWalls setGarage(House.Garage garage) {
            this.garage = Optional.of(garage);
            return this;
        }

        @Override
        public HouseTypeStateBuilderWalls setBasement(House.Basement basement) {
            this.basement = Optional.of(basement);
            return this;
        }

        @Override
        public HouseTypeStateBuilderWalls setWindows(List<House.Window> windows) {
            this.windows = Optional.of(windows);
            return this;
        }
    }

    public class HouseTypeStateBuilderDoors implements HouseTypeStateBuilderBase<HouseTypeStateBuilderDoors> {
        private final List<House.Door> doors;
        private Optional<House.Garage> garage;
        private Optional<House.Basement> basement;
        private Optional<List<House.Window>> windows;

        protected HouseTypeStateBuilderDoors(List<House.Door> doors,
                                             Optional<House.Garage> garage,
                                             Optional<House.Basement> basement,
                                             Optional<List<House.Window>> windows) {
            this.doors = doors;
            this.garage = garage;
            this.basement = basement;
            this.windows = windows;
        }

        public HouseTypeStateBuilderBuildable setWalls(List<House.Wall> walls) {
            return new HouseTypeStateBuilderBuildable(
                    walls, doors, this.garage, this.basement, this.windows
            );
        }

        @Override
        public HouseTypeStateBuilderDoors setGarage(House.Garage garage) {
            this.garage = Optional.of(garage);
            return this;
        }

        @Override
        public HouseTypeStateBuilderDoors setBasement(House.Basement basement) {
            this.basement = Optional.of(basement);
            return this;
        }

        @Override
        public HouseTypeStateBuilderDoors setWindows(List<House.Window> windows) {
            this.windows = Optional.of(windows);
            return this;
        }
    }

    public class HouseTypeStateBuilderBuildable implements HouseTypeStateBuilderBase<HouseTypeStateBuilderBuildable> {
        private List<House.Wall> walls;
        private List<House.Door> doors;
        private Optional<House.Garage> garage;
        private Optional<House.Basement> basement;
        private Optional<List<House.Window>> windows;

        protected HouseTypeStateBuilderBuildable(List<House.Wall> walls,
                                                 List<House.Door> doors,
                                                 Optional<House.Garage> garage,
                                                 Optional<House.Basement> basement,
                                                 Optional<List<House.Window>> windows) {
            this.walls = walls;
            this.doors = doors;
            this.garage = garage;
            this.basement = basement;
            this.windows = windows;
        }

        public House build() {
            return new House(
                    this.walls,
                    this.doors,
                    this.garage,
                    this.basement,
                    this.windows
            );
        }

        @Override
        public HouseTypeStateBuilderBuildable setGarage(House.Garage garage) {
            this.garage = Optional.of(garage);
            return this;
        }

        @Override
        public HouseTypeStateBuilderBuildable setBasement(House.Basement basement) {
            this.basement = Optional.of(basement);
            return this;
        }

        @Override
        public HouseTypeStateBuilderBuildable setWindows(List<House.Window> windows) {
            this.windows = Optional.of(windows);
            return this;
        }

        public HouseTypeStateBuilderBuildable setWalls(List<House.Wall> walls) {
            this.walls = walls;
            return this;
        }

        public HouseTypeStateBuilderBuildable setDoors(List<House.Door> doors) {
            this.doors = doors;
            return this;
        }
    }
}