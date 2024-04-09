package pl.edu.agh.to.lab4.filters;

import pl.edu.agh.to.lab4.model.Suspect;

import java.util.Collection;

public class CompositeSearchStrategy implements SearchStrategy{
    private final Collection<SearchStrategy> searchStrategies;

    public CompositeSearchStrategy(Collection<SearchStrategy> searchStrategies) {
        this.searchStrategies = searchStrategies;
    }

    @Override
    public boolean filter(Suspect suspect) {
        for(SearchStrategy searchStrategy : searchStrategies) {
            if(!searchStrategy.filter(suspect)) {
                return false;
            }
        }
        return true;
    }
}
