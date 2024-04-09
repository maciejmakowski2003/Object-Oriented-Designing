package pl.edu.agh.to.lab4.dataproviders;

import pl.edu.agh.to.lab4.model.Prisoner;

import java.util.*;
import java.util.Iterator;

public class FlatIterator<Suspect> implements Iterator<Suspect> {
    private final Iterator<Prisoner> iterator;

    public FlatIterator(Map<String, Collection<Prisoner>> prisoners) {
        this.iterator = prisoners.values().stream().flatMap(Collection::stream).iterator();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Suspect next() {
        return (Suspect) iterator.next();
    }
}
