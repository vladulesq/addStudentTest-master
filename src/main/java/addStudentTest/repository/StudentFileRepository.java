package addStudentTest.repository;

import addStudentTest.domain.Student;
import addStudentTest.validation.*;

import java.io.*;
import java.util.stream.Collectors;

public class StudentFileRepository extends AbstractFileRepository<Integer, Student> {

    public StudentFileRepository(Validator<Student> validator, String filename) {
        super(validator, filename);
        loadFromFile();
    }

    protected void loadFromFile() {
        try (BufferedReader buffer = new BufferedReader(new FileReader(filename))) {
            buffer.lines().collect(Collectors.toList()).forEach(line -> {
                String[] result = line.split("#");
                Student student = new Student(Integer.parseInt(result[0]), result[1], Integer.parseInt(result[2]));
                try {
                    super.save(student);
                } catch (ValidationException ve) {
                    ve.printStackTrace();
                }
            });
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    protected void writeToFile(Student student) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {
            bw.write(student.getID() + "#" + student.getNume() + "#" + student.getGrupa() + "\n");
        }
        catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    protected void writeToFileAll() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, false))) {
            super.entities.values().forEach(student -> {
                try {
                    bw.write(student.getID() + "#" + student.getNume() + "#" + student.getGrupa() + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
