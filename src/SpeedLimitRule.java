public class SpeedLimitRule implements Rule{
    private final CarType carType;
    private final int maxSpeed;
    private final double fineAmount;

    public SpeedLimitRule(CarType carType, int maxSpeed, double fineAmount) {
        this.carType = carType;
        this.maxSpeed = maxSpeed;
        this.fineAmount = fineAmount;
    }

    @Override
    public Violation evaluate(Observation obs) {
        if (carType == obs.getCarType() && obs.getSpeed() > maxSpeed) {
            String msg = "speed of " + obs.getSpeed() + " exceeded max allowed " + maxSpeed;
            return new Violation(carType + " Speed Limit Exceeded",msg, fineAmount);
        }
        return null;
    }
}
