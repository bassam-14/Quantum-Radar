import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Radar {
    private final List<Rule> rules;
    private final List<Fine> recordedFines;

    public Radar(List<Rule> rules) {
        this.rules = rules;
        this.recordedFines = new ArrayList<>();
    }

    public void processObservation(Observation obs) {
        List<Violation> violations = new ArrayList<>();

        for (Rule rule : rules) {
            Violation v = rule.evaluate(obs);
            if (v != null)
                violations.add(v);
        }

        if (!violations.isEmpty()) {
            Fine fine = new Fine(obs.getPlateNumber(), violations);
            recordedFines.add(fine);
        }
    }

    public List<Fine> getRecordedFines() {
        return recordedFines;
    }

    public Map<String, Double> getAllFines() {
        Map<String, Double> fineTotals = new HashMap<>();
        for (Fine fine : recordedFines) {
            fineTotals.put(fine.getPlateNumber(),
                    fineTotals.getOrDefault(fine.getPlateNumber(), 0.0) + fine.getTotalAmount());
        }
        return fineTotals;
    }

    public Map<String, Integer> getViolatedRulesCount() {
        Map<String, Integer> violationCounts = new HashMap<>();
        for (Fine fine : recordedFines) {
            for (Violation v : fine.getViolations()) {
                String key = v.getRuleBroken();
                violationCounts.put(key, violationCounts.getOrDefault(key, 0) + 1);
            }
        }
        return violationCounts;
    }
}
