import LabAssiAsseProjectMV.Exceptions.*;
import LabAssiAsseProjectMV.Repository.XMLFileRepository.NotaXMLRepo;
import LabAssiAsseProjectMV.Repository.XMLFileRepository.StudentXMLRepo;
import LabAssiAsseProjectMV.Repository.XMLFileRepository.TemaLabXMLRepo;
import LabAssiAsseProjectMV.Service.XMLFileService.NotaXMLService;
import LabAssiAsseProjectMV.Service.XMLFileService.StudentXMLService;
import LabAssiAsseProjectMV.Service.XMLFileService.TemaLabXMLService;
import LabAssiAsseProjectMV.Validator.*;
import LabAssiAsseProjectMV.UI.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ValidatorException {
        //System.out.println("Hello World!");
        StudentValidator vs=new StudentValidator();
        TemaLabValidator vt=new TemaLabValidator();
        NotaValidator vn=new NotaValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        TemaLabXMLRepo tmrepo=new TemaLabXMLRepo(vt,"TemaLaboratorXML.xml");
        NotaXMLRepo ntrepo=new NotaXMLRepo(vn,"NotaXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);
        TemaLabXMLService tmsrv=new TemaLabXMLService(tmrepo);
        NotaXMLService ntsrv=new NotaXMLService(ntrepo);
        ui ui=new ui(stsrv,tmsrv,ntsrv);
        ui.run();
    }
}