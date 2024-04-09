package pl.edu.agh.to.lab4.dataproviders;

import pl.edu.agh.to.lab4.model.Student;
import pl.edu.agh.to.lab4.model.Suspect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class StudentsDataProvider implements SuspectAggregate {
    Collection<Student> students = new ArrayList<>();

    public StudentsDataProvider(){
        students.add(new Student("Anna", "Nowak", "521402", 19));
        students.add(new Student("Piotr", "Jankowski", "632503", 30));
        students.add(new Student("Magdalena", "Lis", "745604", 25));
        students.add(new Student("Tomasz", "Wójcik", "856705", 29));
        students.add(new Student("Monika", "Zając", "967806", 26));
    }

    @Override
    public Iterator<Suspect> iterator() {
        ArrayList<Suspect> suspects = new ArrayList<>(students);
        return suspects.iterator();
    }
}
