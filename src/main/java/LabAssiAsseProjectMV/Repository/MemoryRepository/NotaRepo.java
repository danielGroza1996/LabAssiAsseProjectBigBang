package LabAssiAsseProjectMV.Repository.MemoryRepository;
import LabAssiAsseProjectMV.Validator.IValidator;
import LabAssiAsseProjectMV.Domain.Nota;

public class NotaRepo extends AbstractCrudRepo<Integer,Nota > {
    public NotaRepo(IValidator<Nota> v){ super(v);
    }
}