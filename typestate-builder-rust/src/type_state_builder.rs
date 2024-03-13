use crate::utils::*;

#[derive(Default)]
pub struct NoWalls;

#[derive(Default)]
pub struct Walls(Vec<Wall>);

#[derive(Default)]
pub struct NoDoors;

#[derive(Default)]
pub struct Doors(Vec<Door>);

#[derive(Default)]
pub struct HouseTypeStateBuilder<W, D> {
    walls: W,
    doors: D,
    garage: Option<Garage>,
    basement: Option<Basement>,
    windows: Option<Vec<Window>>,
}

impl HouseTypeStateBuilder<NoWalls, NoDoors> {
    pub fn new() -> Self {
        HouseTypeStateBuilder::default()
    }
}

impl HouseTypeStateBuilder<Walls, Doors> {
    pub fn build(self) -> House {
        House {
            walls: self.walls.0,
            doors: self.doors.0,
            garage: self.garage,
            basement: self.basement,
            windows: self.windows,
        }
    }
}

impl<D> HouseTypeStateBuilder<NoWalls, D> {
    pub fn walls(self, walls: Vec<Wall>) -> HouseTypeStateBuilder<Walls, D> {
        HouseTypeStateBuilder {
            walls: Walls(walls),
            doors: self.doors,
            garage: self.garage,
            basement: self.basement,
            windows: self.windows,
        }
    }
}

impl<W> HouseTypeStateBuilder<W, NoDoors> {
    pub fn doors(self, doors: Vec<Door>) -> HouseTypeStateBuilder<W, Doors> {
        HouseTypeStateBuilder {
            walls: self.walls,
            doors: Doors(doors),
            garage: self.garage,
            basement: self.basement,
            windows: self.windows,
        }
    }
}

impl<W, D> HouseTypeStateBuilder<W, D> {
    pub fn garage(mut self, garage: Garage) -> Self {
        self.garage = Some(garage);
        self
    }

    pub fn basement(mut self, basement: Basement) -> Self {
        self.basement = Some(basement);
        self
    }

    pub fn windows(mut self, windows: Vec<Window>) -> Self {
        self.windows = Some(windows);
        self
    }
}
