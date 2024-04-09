package pl.edu.agh.to.lab4;

import org.junit.jupiter.api.Test;
import pl.edu.agh.to.lab4.dataproviders.CracowCitizensDataProvider;
import pl.edu.agh.to.lab4.dataproviders.PrisonersDataProvider;
import pl.edu.agh.to.lab4.filters.*;
import pl.edu.agh.to.lab4.dataproviders.StudentsDataProvider;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FinderTest {
    private final Finder finder = new Finder(List.of(new CracowCitizensDataProvider(),
            new PrisonersDataProvider(), new StudentsDataProvider()));

    @Test
    void displayTest1(){
        SearchStrategy searchStrategy = new CanBeAccusedSearchStrategy();

        var result = finder.display(searchStrategy);

        assertEquals(20, result.size());
    }

    @Test
    void displayTest2(){
        SearchStrategy searchStrategy = new NameSearchStrategy(null, "Kowalski");

        var result = finder.display(searchStrategy);

        assertEquals(2, result.size());
    }

    @Test
    void displayTest3(){
        SearchStrategy searchStrategy = new NameSearchStrategy("Janusz", "Kowalski");

        var result = finder.display(searchStrategy);

        assertEquals(2, result.size());
    }

    @Test
    void displayTest4(){
        SearchStrategy searchStrategy = new AgeSearchStrategy(10,20);

        var result = finder.display(searchStrategy);

        assertEquals(5, result.size());
    }
}
