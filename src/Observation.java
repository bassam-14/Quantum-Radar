public class Observation {
    private final String plateNumber;
    private final String date; 
    private final String carType;
    private final int speed;
    private final boolean seatbeltFastened;

    public Observation(String plateNumber, String date, String carType, int speed, boolean seatbeltFastened) {
        this.plateNumber = plateNumber;
        this.date = date;
        this.carType = carType;
        this.speed = speed;
        this.seatbeltFastened = seatbeltFastened;
    }

    public String getPlateNumber() { return plateNumber; }
    public String getDate() { return date; }
    public String getCarType() { return carType; }
    public int getSpeed() { return speed; }
    public boolean isSeatbeltFastened() { return seatbeltFastened; }
}
