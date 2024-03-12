use utils::{Basement, Door, Garage, Wall, Window};

mod utils;

#[derive(Debug)]
struct House {
    walls: Vec<Wall>,
    doors: Vec<Door>,
    garage: Option<Garage>,
    basement: Option<Basement>,
    windows: Option<Vec<Window>>,
}

#[derive(Default)]
struct HouseBuilder {
    walls: Option<Vec<Wall>>,
    doors: Option<Vec<Door>>,
    garage: Option<Garage>,
    basement: Option<Basement>,
    windows: Option<Vec<Window>>,
}

impl HouseBuilder {
    fn new() -> Self {
        HouseBuilder::default()
    }

    fn walls(mut self, walls: Vec<Wall>) -> Self {
        self.walls = Some(walls);
        self
    }

    fn doors(mut self, doors: Vec<Door>) -> Self {
        self.doors = Some(doors);
        self
    }

    fn garage(mut self, garage: Garage) -> Self {
        self.garage = Some(garage);
        self
    }

    fn basement(mut self, basement: Basement) -> Self {
        self.basement = Some(basement);
        self
    }

    fn windows(mut self, windows: Vec<Window>) -> Self {
        self.windows = Some(windows);
        self
    }

    fn build(self) -> House {
        House {
            walls: self.walls.unwrap_or_default(),
            doors: self.doors.unwrap_or_default(),
            garage: self.garage,
            basement: self.basement,
            windows: self.windows,
        }
    }
}

fn main() {
    let house = HouseBuilder::new()
        .walls(vec![Wall {}])
        .doors(vec![Door {}])
        .garage(Garage {})
        .basement(Basement {})
        .windows(vec![Window {}])
        .build();
    println!("{:?}", house);
    println!("{}", house.walls.len() != 0);
    println!("{}", house.doors.len() != 0);
    println!("{}", house.garage.is_none());
    println!("{}", house.basement.is_none());
    println!("{}", house.windows.is_none());
}

#[cfg(test)]
mod test {
    use crate::{
        utils::{Door, Wall},
        HouseBuilder,
    };

    #[test]
    fn build_valid_house() -> Result<(), String> {
        let house = HouseBuilder::new()
            .walls(vec![Wall {}])
            .doors(vec![Door {}])
            .build();
        assert!(house.walls.len() != 0);
        assert!(house.doors.len() != 0);
        assert!(house.garage.is_none());
        assert!(house.basement.is_none());
        assert!(house.windows.is_none());

        Ok(())
    }
}
