public interface Rule {
    Violation evaluate(Observation observation);
}
