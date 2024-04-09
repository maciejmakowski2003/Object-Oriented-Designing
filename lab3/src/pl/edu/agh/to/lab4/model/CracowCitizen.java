package pl.edu.agh.to.lab4.model;

import java.util.Objects;

public class CracowCitizen extends Suspect {

    private final int age;

    public CracowCitizen(String firstname, String lastname, int age) {
        super(firstname, lastname);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean canBeAccused(){
        return age>=18;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CracowCitizen that = (CracowCitizen) o;
        return age == that.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), age);
    }
}
