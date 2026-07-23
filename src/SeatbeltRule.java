public class SeatbeltRule implements Rule{
    private final double fineAmount;
    private final String violationMessage;

    public SeatbeltRule(double fineAmount, String violationMessage) {
        this.fineAmount = fineAmount;
        this.violationMessage = violationMessage;
    }

    @Override
    public Violation evaluate(Observation obs) {
        if (!obs.isSeatbeltFastened()) {
            return new Violation("Seatbelt Not Fastened",violationMessage, fineAmount);
        }
        return null;
    }
}
