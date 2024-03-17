import { HouseBuilder } from "./houseBuilder";

const house = HouseBuilder.new()
  .setWalls([])
  .setDoors([])
  .setBasement("Basement")
  .setGarage("Garage")
  .build();

console.log(house);
