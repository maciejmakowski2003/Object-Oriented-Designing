package pl.edu.agh.to.lab4.filters;

import pl.edu.agh.to.lab4.model.Suspect;

public interface SearchStrategy {
    public boolean filter(Suspect suspect);
}
