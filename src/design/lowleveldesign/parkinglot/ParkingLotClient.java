package design.lowleveldesign.parkinglot;


// Provide code for a parking lot with the following assumptions,

// • The parking lot has multiple levels. Each level has multiple rows of spots.
// • The parking lot has motorcycle spots and car spots.
// • A motorcycle can park in any empty spot.
// • A car can only park in a single empty car spot.


// Provide 3 functions for a working parking lot:

// Given a vehicle, you should be able to park it.
// Given a vehicle, you should be able to unpark it.
// Given a spot, you should be able to find the vehicle parked in it.

import java.util.ArrayList;
import java.util.List;

// Main class should be named 'Solution' and should not be public.

enum SpotType {
    CAR, MC
}

interface Vehicle {

    void park();

    void unpark();
}

class Car implements Vehicle {
    Spot spot;
    ParkingManager parkingManager;

    Car(ParkingManager parkingManager) {
        this.parkingManager = parkingManager;
    }

    @Override
    public void park() {
        //todo check if it fits in the spot or not
        //Spot spot=findSpot()

        spot = parkingManager.getEmptySpot(SpotType.CAR);

        spot.setIsEmpty(false);
        System.out.println("vehlical parked");

    }

    @Override
    public void unpark() {
        //todo
        spot.setIsEmpty(true);
        System.out.println("vehlical unparked");
    }
}

class Spot {
    public SpotType spotType;
    public boolean isEmpty;

    Spot(SpotType spotType, boolean isEmpty) {
        this.spotType = spotType;
        this.isEmpty = isEmpty;
    }

    void setIsEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

}

class ParkingLot {
    public String id;
    public List<Level> levels;

    //getter setters
    public ParkingLot(String id, List<Level> levels) {
        this.id = id;
        this.levels = levels;
    }

}

class Level {
    public int levelNumber;
    public List<Row> rows;

    Level(int levelNumber, List<Row> rows) {
        this.rows = rows;
        this.levelNumber = levelNumber;
    }
}

class Row {
    public List<Spot> spots;

    Row(List<Spot> spots) {
        this.spots = spots;
    }

}

class ParkingManager {
    //todo: program to interface
    ParkingLot lot;

    ParkingManager() {
    }

    ParkingManager(ParkingLot lot) {
        this.lot = lot;
    }


    Spot getEmptySpot(SpotType spotType) {
        for (Level level : lot.levels) {
            for (Row row : level.rows) {
                for (Spot spot : row.spots) {
                    if (spotType == SpotType.MC) {
                        if ((spot.spotType == SpotType.MC || spot.spotType == SpotType.CAR) && spot.isEmpty) {
                            return spot;
                        }
                    }

                    if ((spot.spotType == SpotType.CAR) && spot.isEmpty) {
                        return spot;

                    }

                }
            }

        }

        return null;
    }
}


class ParkingLotClient {

    public static void main(String[] args) {
        Spot spot1 = new Spot(SpotType.CAR, true);
        Spot spot2 = new Spot(SpotType.CAR, true);
        Spot spot3 = new Spot(SpotType.MC, true);
        List<Spot> spots = new ArrayList<>();
        spots.add(spot1);
        spots.add(spot2);
        spots.add(spot3);
        Row row = new Row(spots);
        List<Row> rows = new ArrayList<>();
        rows.add(row);
        Level level = new Level(1, rows);
        List<Level> levels = new ArrayList<>();
        levels.add(level);

        ParkingLot lot = new ParkingLot("1", levels);
        ParkingManager parkingManager = new ParkingManager(lot);

        Vehicle car = new Car(parkingManager);
        car.park();
        car.unpark();


    }
}

