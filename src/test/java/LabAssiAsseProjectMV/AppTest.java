package LabAssiAsseProjectMV;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import LabAssiAsseProjectMV.Domain.Student;
import LabAssiAsseProjectMV.Repository.XMLFileRepository.StudentXMLRepo;
import LabAssiAsseProjectMV.Service.XMLFileService.StudentXMLService;
import LabAssiAsseProjectMV.Validator.StudentValidator;

import java.util.stream.StreamSupport;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    /**
     * Creating student entities
     */
    private Student validStudent1 = new Student("1", "Student1", 934, "std1@gmail.com", "Jane Doe");
    private Student validStudent2 = new Student("2A", "Student2", 937, "std2@gmail.com", "John Doe");
    private Student invalidStudent1 = new Student("", "", 0, "", "Jane Doe");
    private Student invalidStudent2 = new Student("", "Nume", -1, "Email", "Jane Doe");

    private String[] validStudentData1 = {validStudent1.getId(), validStudent1.getNume(), String.valueOf(validStudent1.getGrupa()), validStudent1.getEmail(), validStudent1.getIndrumator()};
    private String[] validStudentData2 = {validStudent2.getId(), validStudent2.getNume(), String.valueOf(validStudent2.getGrupa()), validStudent2.getEmail(), validStudent2.getIndrumator()};
    private String[] invalidStudentData1 = {invalidStudent1.getId(), invalidStudent1.getNume(), String.valueOf(invalidStudent1.getGrupa()), invalidStudent1.getEmail(), invalidStudent1.getIndrumator()};
    private String[] invalidStudentData2 = {invalidStudent2.getId(), invalidStudent2.getNume(), String.valueOf(invalidStudent2.getGrupa()), invalidStudent2.getEmail(), invalidStudent2.getIndrumator()};

    /**
     * Creating necessary drivers
     */
    private StudentValidator val = new StudentValidator();
    private StudentXMLRepo repo;
    private StudentXMLService serv;

    @Test
    public void tc_2_numberOfStudents() {
        try {
            repo = new StudentXMLRepo(val, "StudentiXML.xml");
            serv = new StudentXMLService(repo);

            serv.add(validStudentData1);
            serv.add(validStudentData2);
        }
        catch (Exception e) {
            assertTrue(false);
        }
        assertEquals(2, serv.getSize());
    }

    @Test
    public void tc_0_numberOfStudents() {
        try {
            repo = new StudentXMLRepo(val, "StudentiXML.xml");
            serv = new StudentXMLService(repo);

            serv.add(invalidStudentData1);
            serv.add(invalidStudentData2);
        }
        catch (Exception e) {
            assertEquals(0, serv.getSize());
        }
        finally {
            assertEquals(0, serv.getSize());
        }
    }

    @Test
    public void tc_studentDataCorrect() {
        try {
            repo = new StudentXMLRepo(val, "StudentiXML.xml");
            serv = new StudentXMLService(repo);

            serv.add(validStudentData1);
            serv.add(validStudentData2);
        }
        catch (Exception e) {
            assertTrue(false);
        }
        Iterable<Student> students = serv.findAll();
        Student[] stds = StreamSupport.stream(students.spliterator(), false).toArray(Student[]::new);

        assertEquals("1", stds[0].getId());
        assertEquals("Student1", stds[0].getNume());
        assertEquals(934, stds[0].getGrupa());
        assertEquals("std1@gmail.com", stds[0].getEmail());
        assertEquals("Jane Doe", stds[0].getIndrumator());

        assertEquals("2A", stds[1].getId());
        assertEquals("Student2", stds[1].getNume());
        assertEquals(937, stds[1].getGrupa());
        assertEquals("std2@gmail.com", stds[1].getEmail());
        assertEquals("John Doe", stds[1].getIndrumator());
    }

    @Test
    public void tc_correctErrors_invalidStudent1() {
        try {
            repo = new StudentXMLRepo(val, "StudentiXML.xml");
            serv = new StudentXMLService(repo);

            serv.add(invalidStudentData1);
        }
        catch (Exception e) {
            assertEquals("Id invalid\nNume invalid\nGrupa invalid\nEmail invalid\n", e.getMessage());
        }
    }

    @Test
    public void tc_correctErrors_invalidStudent2() {
        try {
            repo = new StudentXMLRepo(val, "StudentiXML.xml");
            serv = new StudentXMLService(repo);

            serv.add(invalidStudentData2);
        }
        catch (Exception e) {
            assertEquals("Id invalid\nGrupa invalid\n", e.getMessage());
        }
    }
}
