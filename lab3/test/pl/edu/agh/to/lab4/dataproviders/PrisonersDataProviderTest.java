package pl.edu.agh.to.lab4.dataproviders;

import org.junit.jupiter.api.Test;
import pl.edu.agh.to.lab4.model.Suspect;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class PrisonersDataProviderTest {

        @Test
        void iteratorTest() {
            PrisonersDataProvider prisonersDataProvider = new PrisonersDataProvider();
            Iterator<Suspect> iterator = prisonersDataProvider.iterator();
            while(iterator.hasNext()){
                assertFalse((iterator.next().toString()).isEmpty());
            }
        }

}