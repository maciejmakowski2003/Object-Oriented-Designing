package pl.edu.agh.to.lab4.model;

import java.util.Objects;

public abstract class Suspect {
    protected final String firstname;

    protected final String lastname;

    public Suspect(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
    public abstract int getAge();

    @Override
    public String toString() {
        return firstname + " " + lastname;
    }

    public abstract boolean canBeAccused();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Suspect suspect = (Suspect) o;
        return Objects.equals(firstname, suspect.firstname) && Objects.equals(lastname, suspect.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname);
    }
}
