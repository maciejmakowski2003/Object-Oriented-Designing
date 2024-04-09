package pl.edu.agh.to.lab4.dataproviders;

import pl.edu.agh.to.lab4.model.Suspect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CompositeAggregate {
    private final Collection<SuspectAggregate> suspectsCollections;

    public CompositeAggregate(Collection<SuspectAggregate> dataAggregates) {
        this.suspectsCollections = dataAggregates;
    }

    public Collection<Suspect> getAllSuspects() {
        Collection<Suspect> suspects = new ArrayList<>();

        for (SuspectAggregate dataAggregate : suspectsCollections) {
            Iterator<Suspect> iterator = dataAggregate.iterator();
            while (iterator.hasNext()) {
                suspects.add(iterator.next());
            }
        }
        return suspects;
    }
}
