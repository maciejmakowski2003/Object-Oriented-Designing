package pl.edu.agh.to.lab4.dataproviders;

import pl.edu.agh.to.lab4.model.Suspect;
import java.util.Iterator;

public interface SuspectAggregate {
    Iterator<Suspect> iterator();
}
