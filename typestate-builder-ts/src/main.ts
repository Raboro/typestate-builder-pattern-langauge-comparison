import { HouseBuilder } from "./houseBuilder";
import { HouseTypeStateBuilder } from "./houseTypeStateBuilder";

const house = HouseBuilder.new()
  .setWalls([])
  .setDoors([])
  .setBasement("Basement")
  .setGarage("Garage")
  .build();

console.log(house);

const house1 = HouseTypeStateBuilder.new()
  .setDoors([])
  .setGarage("Garage")
  .setWalls(["Wall", "Wall"])
  .build();

console.log(house1);
