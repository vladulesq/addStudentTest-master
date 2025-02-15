package addStudentTest.domain;

import java.util.Objects;

public class Student implements HasID<Integer> {
    private int idStudent;
    private String nume;
    private int grupa;

    public Student(int idStudent, String nume, int grupa) {
        this.idStudent = idStudent;
        this.nume = nume;
        this.grupa = grupa;
    }

    @Override
    public Integer getID() { return idStudent; }

    @Override
    public void setID(Integer idStudent) { this.idStudent = idStudent; }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getGrupa() {
        return grupa;
    }

    public void setGrupa(int grupa) {
        this.grupa = grupa;
    }

    @Override
    public String toString() {
        return "Student{" + "idStudent=" + idStudent + ", nume='" + nume + '\'' + ", grupa=" + grupa + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(idStudent, student.idStudent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idStudent);
    }
}

