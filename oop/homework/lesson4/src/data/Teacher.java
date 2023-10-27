package data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Teacher extends User implements Comparable<Teacher> {

    private int Id;
    private static int maxId;
    private List<Disciplines> disciplinesList;
    LocalDate dateOfBirth;

    public Teacher(String firstName, String secondName, String lastName, LocalDate dateOfBirth) {
        super(firstName, secondName, lastName);
        this.Id = ++maxId;
        this.dateOfBirth = dateOfBirth;
    }


    public void setDisciplinesList(List<Disciplines> disciplinesList) {
        this.disciplinesList = disciplinesList;
    }



    public int getId() {
        return Id;
    }


    public List<Disciplines> getDisciplinesList() {
        return disciplinesList;
    }


    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getCountDisciplines() {
        if (disciplinesList == null) return 0;
        return disciplinesList.size();
    }

    @Override
    public int compareTo(Teacher o) {
        int res  = super.getFirstName().compareTo(o.getFirstName());
        if (res == 0) {
            res = super.getSecondName().compareTo(o.getSecondName());
            if (res == 0)
                res = super.getLastName().compareTo(o.getLastName());
        }
        return res;
    }

    @Override
    public String toString() {
        return "Teacher {" +
                "Id = " + Id +
                "; Name = " + super.getFirstName() + " " + super.getSecondName() + " " + super.getLastName()  +
                "; DisciplinesCount = " + getCountDisciplines()  +
                "; dateOfBirth = " + dateOfBirth + '}';
    }
}
