package pl.edu.agh.to.lab4;

import pl.edu.agh.to.lab4.dataproviders.CracowCitizensDataProvider;
import pl.edu.agh.to.lab4.dataproviders.PrisonersDataProvider;
import pl.edu.agh.to.lab4.filters.Finder;
import pl.edu.agh.to.lab4.dataproviders.StudentsDataProvider;
import pl.edu.agh.to.lab4.filters.CanBeAccusedSearchStrategy;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        Finder finder = new Finder(List.of(new PrisonersDataProvider(),
                new CracowCitizensDataProvider(), new StudentsDataProvider()));

        finder.display(new CanBeAccusedSearchStrategy());
    }
}
