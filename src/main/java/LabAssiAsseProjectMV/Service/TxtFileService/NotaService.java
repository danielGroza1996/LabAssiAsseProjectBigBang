package LabAssiAsseProjectMV.Service.TxtFileService;
import LabAssiAsseProjectMV.Domain.*;
import LabAssiAsseProjectMV.Repository.TxtFileRepository.NotaFileRepo;

public class NotaService extends AbstractService<Integer,Nota> {
    public NotaService(NotaFileRepo notaRepo){
        super(notaRepo);
    }
}
