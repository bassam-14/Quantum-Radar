import java.util.ArrayList;
import java.util.List;

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

    public List<Fine> getRecordedFines(){
        return recordedFines;
    }
}
