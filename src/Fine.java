import java.util.ArrayList;
import java.util.List;

public class Fine {
    private final String plateNumber;
    private final List<Violation> violations;

    public Fine(String plateNumber, List<Violation> violations) {
        this.plateNumber = plateNumber;
        this.violations = new ArrayList<>(violations);
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public List<Violation> getViolations() {
        return violations;
    }

    public double getTotalAmount() {
        return violations.stream().mapToDouble(Violation::getFee).sum();
    }

    public void printReceipt() {
        System.out.println("Traffic fine for car " + plateNumber);
        System.out.println("Total amount: " + (int) getTotalAmount() + " EGP");
        System.out.println("Violations:");
        for (Violation v : violations) {
            System.out.println("- " + v.getDescription() + " : " + (int) v.getFee() + " EGP");
        }
    }
}
