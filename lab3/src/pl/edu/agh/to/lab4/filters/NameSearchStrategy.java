package pl.edu.agh.to.lab4.filters;

import pl.edu.agh.to.lab4.model.Suspect;

public class NameSearchStrategy implements SearchStrategy {
    private final String firstname;
    private final String lastname;

    public NameSearchStrategy(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Override
    public boolean filter(Suspect suspect) {
        return (suspect.getFirstname().equals(firstname) || firstname == null) &&
                (suspect.getLastname().equals(lastname) || lastname == null);
    }
}
