package domain;

class CriteriaAlwaysTrue implements Criteria {
    @Override
    public boolean matches(SequenceOfNumber sequenceOfNumber) {
        return true;
    }
}
