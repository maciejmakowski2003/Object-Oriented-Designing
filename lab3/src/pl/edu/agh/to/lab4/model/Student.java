package pl.edu.agh.to.lab4.model;

public class Student extends Suspect {
    private final String index;
    private final int age;

    public Student(String firstname, String lastname, String index, int age) {
        super(firstname, lastname);
        this.index = index;
        this.age = age;
    }

    public String getIndex() {
        return index;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public boolean canBeAccused() {
        return age>=18;
    }
}
