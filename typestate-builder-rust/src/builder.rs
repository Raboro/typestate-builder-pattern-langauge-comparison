use crate::utils::*;

#[derive(Default)]
pub struct HouseBuilder {
    walls: Option<Vec<Wall>>,
    doors: Option<Vec<Door>>,
    garage: Option<Garage>,
    basement: Option<Basement>,
    windows: Option<Vec<Window>>,
}

impl HouseBuilder {
    pub fn new() -> Self {
        HouseBuilder::default()
    }

    pub fn walls(mut self, walls: Vec<Wall>) -> Self {
        self.walls = Some(walls);
        self
    }

    pub fn doors(mut self, doors: Vec<Door>) -> Self {
        self.doors = Some(doors);
        self
    }

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

    pub fn build(self) -> House {
        House {
            walls: self.walls.unwrap_or_default(),
            doors: self.doors.unwrap_or_default(),
            garage: self.garage,
            basement: self.basement,
            windows: self.windows,
        }
    }
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
        assert!(!house.walls.is_empty());
        assert!(!house.doors.is_empty());
        assert!(house.garage.is_none());
        assert!(house.basement.is_none());
        assert!(house.windows.is_none());

        Ok(())
    }
}
