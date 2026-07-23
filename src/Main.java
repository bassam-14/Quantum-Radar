import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Rule> rules = new ArrayList<>();
        rules.add(new SeatbeltRule(RadarConfig.SEATBELT_FINE, "Seatbelt not fastened"));
        rules.add(new SpeedLimitRule(CarType.PRIVATE, RadarConfig.PRIVATE_MAX_SPEED, RadarConfig.PRIVATE_SPEED_FINE));
        rules.add(new SpeedLimitRule(CarType.TRUCK, RadarConfig.TRUCK_MAX_SPEED, RadarConfig.TRUCK_SPEED_FINE));

        Radar radar = new Radar(rules);

        Observation obs1 = new Observation("ABC1234", "2026-07-23", CarType.PRIVATE, 94, false);
        Observation obs2 = new Observation("XYZ9876", "2026-07-23", CarType.TRUCK, 55, true);
        Observation obs3 = new Observation("DEF5678", "2026-07-23", CarType.TRUCK, 70, false);

        radar.processObservation(obs1);
        radar.processObservation(obs2);
        radar.processObservation(obs3);

        List<Fine> fines = radar.getRecordedFines();
        for (Fine fine : fines) {
            fine.printReceipt();
            System.out.println();
        }

        // Get all fines
        System.out.println("All fines:");
        Map<String, Double> allFines = radar.getAllFines();
        for (Map.Entry<String, Double> entry : allFines.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue().intValue() + " EGP");
        }
        System.out.println();

        // Get all violated rules with count of each
        Map<String, Integer> violationCounts = radar.getViolatedRulesCount();
        System.out.println("Violated rules count:");
        for (Map.Entry<String, Integer> entry : violationCounts.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue() + " times");
        }
    }
}
