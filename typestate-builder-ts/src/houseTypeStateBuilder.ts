import { Wall, Door, Garage, Basement, _Window, House } from "./utils";

export class HouseTypeStateBuilder {
  private garage?: Garage;
  private basement?: Basement;
  private windows?: _Window[];

  static new(): HouseTypeStateBuilder {
    return new HouseTypeStateBuilder();
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

  setWalls(walls: Wall[]): HouseTypeStateBuilderWalls {
    return new HouseTypeStateBuilderWalls(
      walls,
      this.garage,
      this.basement,
      this.windows
    );
  }

  setDoors(doors: Door[]): HouseTypeStateBuilderDoors {
    return new HouseTypeStateBuilderDoors(
      doors,
      this.garage,
      this.basement,
      this.windows
    );
  }
}

export class HouseTypeStateBuilderWalls {
  private walls: Wall[];
  private garage?: Garage;
  private basement?: Basement;
  private windows?: _Window[];

  constructor(
    walls: Wall[],
    garage?: Garage,
    basement?: Basement,
    windows?: _Window[]
  ) {
    this.walls = walls;
    this.garage = garage;
    this.basement = basement;
    this.windows = windows;
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

  setDoors(doors: Door[]): HouseTypeStateBuilderBuildable {
    return new HouseTypeStateBuilderBuildable(
      this.walls,
      doors,
      this.garage,
      this.basement,
      this.windows
    );
  }
}

export class HouseTypeStateBuilderDoors {
  private doors: Door[];
  private garage?: Garage;
  private basement?: Basement;
  private windows?: _Window[];

  constructor(
    doors: Door[],
    garage?: Garage,
    basement?: Basement,
    windows?: _Window[]
  ) {
    this.doors = doors;
    this.garage = garage;
    this.basement = basement;
    this.windows = windows;
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

  setWalls(walls: Wall[]): HouseTypeStateBuilderBuildable {
    return new HouseTypeStateBuilderBuildable(
      walls,
      this.doors,
      this.garage,
      this.basement,
      this.windows
    );
  }
}

export class HouseTypeStateBuilderBuildable {
  private walls: Wall[];
  private doors: Door[];
  private garage?: Garage;
  private basement?: Basement;
  private windows?: _Window[];

  constructor(
    walls: Wall[],
    doors: Door[],
    garage?: Garage,
    basement?: Basement,
    windows?: _Window[]
  ) {
    this.walls = walls;
    this.doors = doors;
    this.garage = garage;
    this.basement = basement;
    this.windows = windows;
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
      this.walls,
      this.doors,
      this.garage,
      this.basement,
      this.windows
    );
  }
}
