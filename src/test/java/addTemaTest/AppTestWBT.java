package addTemaTest;

import addStudentTest.domain.Nota;
import addStudentTest.domain.Student;
import addStudentTest.domain.Tema;
import addStudentTest.repository.NotaXMLRepository;
import addStudentTest.repository.StudentXMLRepository;
import addStudentTest.repository.TemaXMLRepository;
import addStudentTest.service.Service;
import addStudentTest.validation.NotaValidator;
import addStudentTest.validation.StudentValidator;
import addStudentTest.validation.TemaValidator;
import addStudentTest.validation.Validator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTestWBT
{
    /**
     * Rigorous Test :-)
     */
    private StudentXMLRepository rep1;
    private NotaXMLRepository rep2;
    private TemaXMLRepository rep3;
    private Service srv;

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void my_test_1(){
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        rep1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        rep3 = new TemaXMLRepository(temaValidator, "teme.xml");
        rep2 = new NotaXMLRepository(notaValidator, "note.xml");
        srv = new Service(rep1, rep3, rep2);
        boolean result = srv.saveTema("357","asd",265, 7);
        assertEquals(false, result);//deadline invalid
    }

    @Test
    public void my_test_2(){
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        rep1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        rep3 = new TemaXMLRepository(temaValidator, "teme.xml");
        rep2 = new NotaXMLRepository(notaValidator, "note.xml");
        srv = new Service(rep1, rep3, rep2);
        boolean result = srv.saveTema("123","asd",10, 7);
        assertEquals(true, result);}

}
