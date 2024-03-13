use utils::{Basement, Door, Garage, Wall, Window};

use crate::builder::HouseBuilder;

mod builder;
mod utils;

fn main() {
    let house = HouseBuilder::new()
        .walls(vec![Wall {}])
        .doors(vec![Door {}])
        .garage(Garage {})
        .basement(Basement {})
        .windows(vec![Window {}])
        .build();
    println!("{:?}", house);
    println!("{}", !house.walls.is_empty());
    println!("{}", !house.doors.is_empty());
    println!("{}", house.garage.is_none());
    println!("{}", house.basement.is_none());
    println!("{}", house.windows.is_none());
}
