package pl.edu.agh.to.lab4.filters;

import pl.edu.agh.to.lab4.model.Suspect;

public class CanBeAccusedSearchStrategy implements SearchStrategy {

    @Override
    public boolean filter(Suspect suspect) {
        return suspect.canBeAccused();
    }
}
