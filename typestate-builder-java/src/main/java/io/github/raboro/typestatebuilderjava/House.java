package io.github.raboro.typestatebuilderjava;

import java.util.List;
import java.util.Optional;

public class House {
    private final List<Wall> walls;
    private final List<Door> doors;
    private final Optional<Garage> garage;
    private final Optional<Basement> basement;
    private final Optional<List<Window>> windows;

    public House(List<Wall> walls, List<Door> doors, Optional<Garage> garage, Optional<Basement> basement, Optional<List<Window>> windows) {
        this.walls = walls;
        this.doors = doors;
        this.garage = garage;
        this.basement = basement;
        this.windows = windows;
    }

    public record Wall() {}

    public record Door() {}

    public record Garage() {}

    public record Basement() {}

    public record Window() {}
}
