public class Violation {
    private final String ruleBroken;
    private final String description;
    private final double fee;

    public Violation(String ruleBroken, String description, double fee) {
        this.ruleBroken = ruleBroken;
        this.description = description;
        this.fee = fee;
    }

    public double getFee() {
        return fee;
    }

    public String getDescription() {
        return description;
    }

   public String getRuleBroken() { return ruleBroken; }
}
