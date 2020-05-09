package addStudentTest.repository;

import addStudentTest.domain.Tema;
import addStudentTest.validation.*;

public class TemaRepository extends AbstractCRUDRepository<String, Tema> {
    public TemaRepository(Validator<Tema> validator) {
        super(validator);
    }
}

