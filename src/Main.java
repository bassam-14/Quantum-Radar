import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Rule> rules = new ArrayList<>();
        rules.add(new SeatbeltRule(RadarConfig.SEATBELT_FINE, "Seatbelt not fastened"));
        rules.add(new SpeedLimitRule(CarType.Private, RadarConfig.PRIVATE_MAX_SPEED, RadarConfig.PRIVATE_SPEED_FINE));
        rules.add(new SpeedLimitRule(CarType.Truck, RadarConfig.TRUCK_MAX_SPEED, RadarConfig.TRUCK_SPEED_FINE));

        Radar radar = new Radar(rules);

        Observation obs1 = new Observation("ABC1234", "2026-07-23", CarType.Private, 94, false);
        Observation obs2 = new Observation("XYZ9876", "2026-07-23", CarType.Truck, 55, true); 
        Observation obs3 = new Observation("DEF5678", "2026-07-23", CarType.Truck, 70, false);

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
        for (Fine fine: fines){
            System.out.println(fine.getPlateNumber() + " : " + fine.getTotalAmount() + "EGP");
        }
        System.out.println();

        // Get all violated rules with count of each
        Map<String, Integer> violationCounts = new HashMap<>();
        System.out.println("Violated rules count:");
        for (Fine fine : fines){
            for (Violation v : fine.getViolations()){
                String key = v.getRuleBroken();
                violationCounts.put(key, violationCounts.getOrDefault(key, 0) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : violationCounts.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }
}
