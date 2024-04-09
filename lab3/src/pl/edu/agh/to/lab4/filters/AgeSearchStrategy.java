package pl.edu.agh.to.lab4.filters;

import pl.edu.agh.to.lab4.model.Suspect;

public class AgeSearchStrategy implements SearchStrategy {
    private final int minAge;
    private final int maxAge;

    public AgeSearchStrategy(int minAge, int maxAge) {
        if(minAge > maxAge) {
            throw new IllegalArgumentException("Min age cannot be greater than max age");
        }
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    @Override
    public boolean filter(Suspect suspect) {
        return suspect.getAge() >= minAge && suspect.getAge() <= maxAge;
    }
}
