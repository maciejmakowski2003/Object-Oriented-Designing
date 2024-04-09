package pl.edu.agh.to.lab4.model;

import java.util.Calendar;
import java.util.Objects;

public class Prisoner extends Suspect {
    private final int judgementYear;

    private final int sentenceDuration;

    private final String pesel;

    public Prisoner(String firstname, String lastname, String pesel, int judgementYear, int sentenceDuration) {
        super(firstname, lastname);
        this.pesel = pesel;
        this.judgementYear = judgementYear;
        this.sentenceDuration = sentenceDuration;
    }
    public int getAge() {
        int peselYear = Integer.parseInt(pesel.substring(0, 2));
        int peselMonth = Integer.parseInt(pesel.substring(2, 4));
        int birthYear = peselMonth >=20 ? 2000 + peselYear : 1900 + peselYear;

        return getCurrentYear() - birthYear;
    }

    private boolean isJailed() {
        return judgementYear + sentenceDuration >= getCurrentYear();
    }

    @Override
    public boolean canBeAccused() {
        return !isJailed() && getAge() >= 18;
    }

    public int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Prisoner prisoner = (Prisoner) o;
        return judgementYear == prisoner.judgementYear && sentenceDuration == prisoner.sentenceDuration && Objects.equals(pesel, prisoner.pesel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), judgementYear, sentenceDuration, pesel);
    }
}
