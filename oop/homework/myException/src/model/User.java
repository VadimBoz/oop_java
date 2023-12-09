package model;

import java.time.LocalDate;

public class User {
    private String firstName;
    private String secondName;
    private String patronymic;
    private Telephone  tel;
    LocalDate dateBirth;
    Gender gender;


    public User(String secondName, String firstName, String patronymic, LocalDate dateBirth, Telephone tel, Gender gender) {
        this.secondName = secondName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.dateBirth = dateBirth;
        this.tel = tel;
        this.gender = gender;
    }

    public User(String[] strAr) {
        if (strAr.length == 6) {
            this.secondName = strAr[0];
            this.firstName = strAr[1];
            this.patronymic = strAr[2];
            this.dateBirth = LocalDate.parse(strAr[3]);
            this.tel = Telephone.parseTelephone(strAr[4]);
            this.gender = Gender.parseGender(strAr[5]);
        } else
            throw new IllegalArgumentException("Неверное количество аргументов");
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setTelephone(Telephone tel) {
        this.tel = tel;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getTelephone() {
        return tel.toString();
    }

    public Telephone getTelephoneNumber() {
        return tel;
    }

    @Override
    public String toString() {
        return secondName + ";" + firstName + ";" + firstName + ";" +
                dateBirth + ";" + tel.getNumber() + ";" + gender + "\n";
    }


    public String toTableView() {
        return  "SecondName: " + secondName + "\n" +
                "FirstName:  " + firstName + "\n" +
                "Patronymic: " + patronymic + "\n" +
                "DateBirth:  " + dateBirth + "\n" +
                "Telephone:  " + tel       + "\n" +
                "Gender:     " + gender + "\n";
    }

}
