export type Wall = "Wall";
export type Door = "Door";
export type Garage = "Garage";
export type Basement = "Basement";
export type _Window = "Window";

export class House {
  constructor(
    readonly walls: Wall[],
    readonly doors: Door[],
    readonly garage?: Garage,
    readonly basement?: Basement,
    readonly windows?: _Window[]
  ) {}
}
