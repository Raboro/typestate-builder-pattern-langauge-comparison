import { Wall, Door, Garage, Basement, _Window, House } from "./utils";

export class HouseBuilder {
    private walls?: Wall[];
    private doors?: Door[];
    private garage?: Garage;
    private basement?: Basement;
    private windows?: _Window[];

  static new(): HouseBuilder {
    return new HouseBuilder();
  }

  setWalls(walls: Wall[]): this {
    this.walls = walls;
    return this;
  }

  setDoors(doors: Door[]): this {
    this.doors = doors;
    return this;
  }

  setGarage(garage: Garage): this {
    this.garage = garage;
    return this;
  }

  setBasement(basement: Basement): this {
    this.basement = basement;
    return this;
  }

  setWindows(windows: _Window[]): this {
    this.windows = windows;
    return this;
  }

  build(): House {
    return new House(
      this.walls ?? [],
      this.doors ?? [],
      this.garage,
      this.basement,
      this.windows  
    );
  }

}
