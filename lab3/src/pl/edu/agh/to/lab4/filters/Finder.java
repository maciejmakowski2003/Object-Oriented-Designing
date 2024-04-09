package pl.edu.agh.to.lab4.filters;

import pl.edu.agh.to.lab4.dataproviders.CompositeAggregate;
import pl.edu.agh.to.lab4.dataproviders.SuspectAggregate;
import pl.edu.agh.to.lab4.filters.SearchStrategy;
import pl.edu.agh.to.lab4.model.Suspect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Finder {
    private final Collection<Suspect> suspects;

    public Finder(Collection<SuspectAggregate> suspects) {
        this.suspects = new CompositeAggregate(suspects).getAllSuspects();
    }

    public Collection<Suspect> display(SearchStrategy searchStrategy) {
        List<Suspect> result = new ArrayList<>();

        for (Suspect suspect : suspects) {
            if (searchStrategy.filter(suspect)) {
                result.add(suspect);
            }
        }

        System.out.println("Znalazlem " + result.size() + " pasujacych podejrzanych!");

        for(Suspect suspect : result) {
            System.out.println(suspect.toString());
        }

        return Collections.unmodifiableList(result);
    }

}
