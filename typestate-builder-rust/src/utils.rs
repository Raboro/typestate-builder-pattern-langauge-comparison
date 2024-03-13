#[derive(Debug)]
pub struct Wall;

#[derive(Debug)]
pub struct Door;

#[derive(Debug)]
pub struct Garage;

#[derive(Debug)]
pub struct Basement;

#[derive(Debug)]
pub struct Window;

#[derive(Debug)]
pub struct House {
    pub walls: Vec<Wall>,
    pub doors: Vec<Door>,
    pub garage: Option<Garage>,
    pub basement: Option<Basement>,
    pub windows: Option<Vec<Window>>,
}
