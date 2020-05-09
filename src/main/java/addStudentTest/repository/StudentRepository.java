package addStudentTest.repository;

import addStudentTest.domain.Student;
import addStudentTest.validation.*;

public class StudentRepository extends AbstractCRUDRepository<Integer, Student> {
    public StudentRepository(Validator<Student> validator) {
        super(validator);
    }
}

