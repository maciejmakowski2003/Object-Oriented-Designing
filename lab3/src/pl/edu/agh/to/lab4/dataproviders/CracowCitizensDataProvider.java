package pl.edu.agh.to.lab4.dataproviders;

import pl.edu.agh.to.lab4.model.CracowCitizen;
import pl.edu.agh.to.lab4.model.Suspect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CracowCitizensDataProvider implements SuspectAggregate {

    private final Collection<CracowCitizen> cracowCitizens = new ArrayList<>();

    public CracowCitizensDataProvider() {
        cracowCitizens.add(new CracowCitizen("Janusz", "Kowalski", 30));
        cracowCitizens.add(new CracowCitizen("Janusz", "Krakowski", 30));
        cracowCitizens.add(new CracowCitizen("Janusz", "Mlodociany", 10));
        cracowCitizens.add(new CracowCitizen("Kasia", "Kosinska", 19));
        cracowCitizens.add(new CracowCitizen("Piotr", "Zgredek", 29));
        cracowCitizens.add(new CracowCitizen("Tomek", "Gimbus", 14));
        cracowCitizens.add(new CracowCitizen("Janusz", "Gimbus", 15));
        cracowCitizens.add(new CracowCitizen("Alicja", "Zaczarowana", 22));
        cracowCitizens.add(new CracowCitizen("Janusz", "Programista", 77));
        cracowCitizens.add(new CracowCitizen("Pawel", "Pawlowicz", 32));
        cracowCitizens.add(new CracowCitizen("Krzysztof", "Mendel", 30));
    }

    @Override
    public Iterator<Suspect> iterator() {
        ArrayList<Suspect> suspects = new ArrayList<>(cracowCitizens);
        return suspects.iterator();
    }
}
