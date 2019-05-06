package LabAssiAsseProjectMV;

import LabAssiAsseProjectMV.Domain.Nota;
import LabAssiAsseProjectMV.Domain.TemaLab;
import LabAssiAsseProjectMV.Repository.XMLFileRepository.NotaXMLRepo;
import LabAssiAsseProjectMV.Repository.XMLFileRepository.TemaLabXMLRepo;
import LabAssiAsseProjectMV.Service.XMLFileService.NotaXMLService;
import LabAssiAsseProjectMV.Service.XMLFileService.TemaLabXMLService;
import LabAssiAsseProjectMV.Validator.NotaValidator;
import LabAssiAsseProjectMV.Validator.TemaLabValidator;
import org.junit.Test;

import LabAssiAsseProjectMV.Domain.Student;
import LabAssiAsseProjectMV.Repository.XMLFileRepository.StudentXMLRepo;
import LabAssiAsseProjectMV.Service.XMLFileService.StudentXMLService;
import LabAssiAsseProjectMV.Validator.StudentValidator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.StreamSupport;

import static org.junit.Assert.*;

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
     * Creating Domain Entities
     */
    String str = "2018-10-01 12:30";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    LocalDateTime dateTime = LocalDateTime.parse(str, formatter);

    private Student student = new Student("1", "Student", 934, "student@gmail.com", "Name");
    private TemaLab temaLab = new TemaLab(1, "Description", 2, 2);
    private Nota nota = new Nota(1,"1",1,10.0, dateTime);

    private String[] studentS = {student.getId(), student.getNume(), String.valueOf(student.getGrupa()), student.getEmail(), student.getIndrumator()};
    private String[] temaLabS = {String.valueOf(temaLab.getId()), temaLab.getDescriere(), String.valueOf(temaLab.getTermenLimita()), String.valueOf(temaLab.getSaptammanaPredarii())};
    private String[] notaS = {String.valueOf(nota.getId()), nota.getStudentId(), String.valueOf(nota.getTemaLabId()), String.valueOf(nota.getValoare()), "" + nota.getLdt()};
    /**
     * Creating necessary drivers
     */
    private StudentValidator stdVal = new StudentValidator();
    private StudentXMLRepo stdRepo = new StudentXMLRepo(stdVal, "StudentiXML.xml");
    private StudentXMLService stdServ = new StudentXMLService(stdRepo);

    private TemaLabValidator tlbVal = new TemaLabValidator();
    private TemaLabXMLRepo tlbRepo = new TemaLabXMLRepo(tlbVal, "TemaLaboratorXML.xml");
    private TemaLabXMLService tlbServ = new TemaLabXMLService(tlbRepo);

    private NotaValidator ntVal = new NotaValidator();
    private NotaXMLRepo ntRepo = new NotaXMLRepo(ntVal, "NotaXML.xml");
    private NotaXMLService ntServ = new NotaXMLService(ntRepo);

    @Test
    public void tc_1_addedStudents() {
        try {
            stdServ.add(studentS);
        }
        catch (Exception e) {
            fail();
        }
        assertEquals(1, stdServ.getSize());
    }

    @Test
    public void tc_1_addedAssignments() {
        try {
            tlbServ.add(temaLabS);
        }
        catch (Exception e) {
            fail();
        }
        assertEquals(1, tlbServ.getSize());
    }

    @Test
    public void tc_1_addedGrades() {
        try {
            ntServ.add(notaS);
        }
        catch (Exception e) {
            fail();
        }
        assertEquals(1, ntServ.getSize());
    }

    @Test
    public void tc_integ_all() {
        try {
            stdServ.add(studentS);
            tlbServ.add(temaLabS);
            ntServ.add(notaS);
        }
        catch (Exception e) {
            fail();
        }
        assertEquals(1, stdServ.getSize());
        assertEquals(1, tlbServ.getSize());
        assertEquals(1, ntServ.getSize());
    }

    /**
     * Incremental Integration (top-down)
     */
    @Test
    public void tc_incremental_addStudents() {
        try {
            stdServ.add(studentS);
        }
        catch (Exception e) {
            fail();
        }
        assertEquals(1, stdServ.getSize());
    }

    @Test
    public void tc_incremental_addAssignments() {
        try {
            stdServ.add(studentS);
            tlbServ.add(temaLabS);
        }
        catch (Exception e) {
            fail();
        }
        assertEquals(1, tlbServ.getSize());
        assertEquals(1, stdServ.getSize());
    }

    @Test
    public void tc_incremental_all() {
        try {
            stdServ.add(studentS);
            tlbServ.add(temaLabS);
            ntServ.add(notaS);
        }
        catch (Exception e) {
            fail();
        }
        assertEquals(1, stdServ.getSize());
        assertEquals(1, tlbServ.getSize());
        assertEquals(1, ntServ.getSize());
    }
}
